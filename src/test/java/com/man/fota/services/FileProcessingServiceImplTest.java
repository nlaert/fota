package com.man.fota.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.File;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class FileProcessingServiceImplTest {

    @Mock
    private VehicleService vehicleService;

    private FileProcessingService fileProcessingService;
    private final String fileName = "soft_1.csv";

    @BeforeEach
    void setUp() {
        vehicleService = mock(VehicleService.class);
        fileProcessingService = new FileProcessingServiceImpl(vehicleService);
    }

    @Test
    public void processNewFile() {
        File file = new File("src/test/resources/soft_1.csv");
        fileProcessingService.processNewFile(file);

        // As the DUPLICATE_BATCH_REMOVAL_SIZE is set to 1000, the removeDuplicates should not be called
        verify(vehicleService, times(0)).removeDuplicates(anySet(), anySet());
        verify(vehicleService, times(1)).saveBatch(eq(fileName), anySet(), anySet(), anyList());
    }

    @Test
    void shouldNotProcessFileWithIncorrectName() {
        // The purpose of this test is to avoid the processing of the file, so a different file is enough
        File file = new File("src/test/resources/data-h2.sql");
        fileProcessingService.processNewFile(file);

        verify(vehicleService, times(0)).removeDuplicates(anySet(), anySet());
        verify(vehicleService, times(0)).saveBatch(eq("data-h2.sql"), anySet(), anySet(), anyList());
    }
}