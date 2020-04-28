package com.man.fota.schedulers;

import com.man.fota.services.FileProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

@Component
public class CheckFilesScheduler implements EnvironmentAware {

    private static final Logger LOG = LoggerFactory.getLogger(CheckFilesScheduler.class);

    private final FileProcessingService fileProcessingService;
    private String filesPath;
    private WatchService watchService;

    @Autowired
    public CheckFilesScheduler(FileProcessingService fileProcessingService) {
        this.fileProcessingService = fileProcessingService;
    }

    /**
     * Checks the file system for new files to process.
     */
    @Scheduled(fixedDelayString = "${fota.vehicle_files.watch_rate:60000}")
    public void processNewFiles() {
        WatchKey watchKey = watchService.poll();
        if (watchKey != null) {
            watchKey.pollEvents().forEach(watchEvent ->
                    fileProcessingService.processNewFile(filesPath, watchEvent.context().toString()));
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
