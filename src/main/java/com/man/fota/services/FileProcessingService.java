package com.man.fota.services;

public interface FileProcessingService {

    /**
     * Reads the content of the received file and stores it into the DB.
     *  @param filePath the new file to read.
     * @param fileName the name of the file.
     * @return returns true when the file was processed correctly
     */
    boolean processNewFile(String filePath, String fileName);
}
