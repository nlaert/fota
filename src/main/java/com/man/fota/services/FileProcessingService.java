package com.man.fota.services;

import java.io.File;

public interface FileProcessingService {

    /**
     * Reads the content of the received file and stores it into the DB.
     * @param file the file to process
     * @return returns true when the file was processed correctly
     */
    boolean processNewFile(File file);
}
