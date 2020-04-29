package com.man.fota.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
        fileProcessingService.processNewFile("src/test/resources", fileName);

        // As the DUPLICATE_BATCH_REMOVAL_SIZE is set to 1000, the removeDuplicates should not be called
        verify(vehicleService, times(0)).removeDuplicates(anySet(), anySet());
        verify(vehicleService, times(1)).saveBatch(eq(fileName), anySet(), anySet(), anyList());
    }

    @Test
    void shouldNotProcessFileWithIncorrectName() {
        String wrongFileName = "wrongFileName";
        fileProcessingService.processNewFile("classpath:/resources/", wrongFileName);

        verify(vehicleService, times(0)).removeDuplicates(anySet(), anySet());
        verify(vehicleService, times(0)).saveBatch(eq(wrongFileName), anySet(), anySet(), anyList());
    }
}