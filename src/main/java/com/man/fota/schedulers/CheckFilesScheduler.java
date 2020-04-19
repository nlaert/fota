package com.man.fota.schedulers;

import com.man.fota.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;

@Component
public class CheckFilesScheduler implements EnvironmentAware {

    private static final Logger LOG = LoggerFactory.getLogger(CheckFilesScheduler.class);

    private final VehicleService vehicleService;
    private String filesPath;
    private WatchService watchService;

    @Autowired
    public CheckFilesScheduler(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Scheduled(fixedDelayString = "${fota.vehicle_files.watch_rate:60000}")
    public void processNewFiles() {
        WatchKey watchKey = watchService.poll();
        if (watchKey != null) {
            watchKey.pollEvents().forEach(watchEvent ->
                    vehicleService.processNewFile(filesPath, watchEvent.context().toString()));
            watchKey.reset();
        }
    }

    @Override
    public void setEnvironment(final Environment environment) {
        filesPath = environment.getProperty("fota.vehicle_files.path");
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(filesPath);
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        } catch (IOException e) {
            LOG.error("Error creating watch Service.", e);
        }
    }
}
