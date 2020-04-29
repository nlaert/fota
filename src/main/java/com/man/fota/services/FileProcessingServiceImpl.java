package com.man.fota.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.man.fota.entities.CodeEntity;
import com.man.fota.entities.VehicleCodeKey;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

    private static final Logger LOG = LoggerFactory.getLogger(FileProcessingServiceImpl.class);

    private static final String HARDWARE_FILE_PREFIX = "hard_";
    private static final String SOFTWARE_FILE_PREFIX = "soft_";
    private static final int DUPLICATE_BATCH_REMOVAL_SIZE = 1000;

    private final VehicleService vehicleService;

    @Autowired
    public FileProcessingServiceImpl(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @Override
    public boolean processNewFile(final String filePath, final String fileName) {
        if (!fileName.startsWith(HARDWARE_FILE_PREFIX) && !fileName.startsWith(SOFTWARE_FILE_PREFIX)) {
            return false;
        }
        try {
            LOG.debug("Starting to read file {}", fileName);
            boolean isHardware = fileName.startsWith(HARDWARE_FILE_PREFIX);
            Set<VehicleEntity> vehicles = new HashSet<>();
            Set<CodeEntity> codes = new HashSet<>();
            List<VehicleCodesEntity> vehicleCodes = new ArrayList<>(DUPLICATE_BATCH_REMOVAL_SIZE);
            List<String[]> lines = readFile(filePath + "/" + fileName);
            int counter = 0;
            for (String[] line : lines) {
                String vin = line[0];
                String code = line[1];
                VehicleEntity vehicleEntity = new VehicleEntity(vin);
                vehicles.add(vehicleEntity);
                CodeEntity codeEntity = new CodeEntity(code, isHardware);
                codes.add(codeEntity);
                VehicleCodeKey vehicleCodeKey = new VehicleCodeKey(vehicleEntity, codeEntity);
                vehicleCodes.add(new VehicleCodesEntity(vehicleCodeKey));
                if (++counter >= DUPLICATE_BATCH_REMOVAL_SIZE) {
                    vehicleService.removeDuplicates(vehicles, codes);
                    counter = 0;
                }
            }
            vehicleService.saveBatch(fileName, vehicles, codes, vehicleCodes);
            LOG.debug("Finished reading file {}", fileName);

        } catch (IOException e) {
            LOG.error("Could not read file {}.", filePath, e);
            return false;
        }
        return true;
    }

    private List<String[]> readFile(final String filePath) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        File file = new File(filePath);
        MappingIterator<String[]> mappingIterator = mapper.readerFor(String[].class).with(csvSchema).readValues(file);
        return mappingIterator.readAll();
    }
}
