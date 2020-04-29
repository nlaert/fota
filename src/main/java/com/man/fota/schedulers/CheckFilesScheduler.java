package com.man.fota.schedulers;

import com.man.fota.services.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CheckFilesScheduler {

    private final FileProcessingService fileProcessingService;
    @Value("${fota.vehicle_files.path}")
    private String filesPath;

    @Autowired
    public CheckFilesScheduler(FileProcessingService fileProcessingService) {
        this.fileProcessingService = fileProcessingService;
    }

    /**
     * Checks the file system for new files to process.
     */
    @Scheduled(fixedDelayString = "${fota.vehicle_files.watch_rate:60000}")
    public void processNewFiles() {
        File dir = new File(filesPath);
        if(dir.listFiles() != null) {
            for (File file : dir.listFiles()) {
                if (fileProcessingService.processNewFile(filesPath, file.getName())) {
                    file.delete();
                }
            }
        }
    }
}
