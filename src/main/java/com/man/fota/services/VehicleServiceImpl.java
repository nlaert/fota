package com.man.fota.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.man.fota.entities.*;
import com.man.fota.repositories.CodeRepository;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleCodesRepository;
import com.man.fota.repositories.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleServiceImpl.class);
    private static final String HARDWARE_FILE_PREFIX = "hard_";
    private static final String SOFTWARE_FILE_PREFIX = "soft_";

    private final VehicleRepository vehicleRepository;
    private final CodeRepository codeRepository;
    private final VehicleCodesRepository vehicleCodesRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public VehicleServiceImpl(final FeatureRepository featureRepository,
                              final VehicleRepository vehicleRepository,
                              final CodeRepository codeRepository,
                              final VehicleCodesRepository vehicleCodesRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
        this.codeRepository = codeRepository;
        this.vehicleCodesRepository = vehicleCodesRepository;
    }

    @Override
    public List<FeatureEntity> getInstallableFeaturesByVehicle(String vin) {
        return featureRepository.getFeaturesByVin(vin, true);
    }

    @Override
    public List<FeatureEntity> getIncompatibleFeaturesByVehicle(String vin) {
        return featureRepository.getFeaturesByVin(vin, false);
    }

    @Override
    public List<FeatureEntity> getAllFeaturesByVehicle(String vin) {
        return featureRepository.getFeaturesByVin(vin, null);
    }

    @Override
    public List<VehicleEntity> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public void processNewFile(final String filePath, final String fileName) {
        if (!fileName.startsWith(HARDWARE_FILE_PREFIX) && !fileName.startsWith(SOFTWARE_FILE_PREFIX)) {
            return;
        }
        try {
            LOG.debug("Starting to read file {}", fileName);
            boolean isHardware = fileName.startsWith(HARDWARE_FILE_PREFIX);
            HashSet<VehicleEntity> vehicles = new HashSet<>();
            HashSet<CodeEntity> codes = new HashSet<>();
            List<VehicleCodesEntity> vehicleCodes = new ArrayList<>();
            List<String[]> lines = readFile(filePath + "/" + fileName);
            for (String[] line : lines) {
                String vin = line[0];
                String code = line[1];
                VehicleEntity vehicleEntity = new VehicleEntity(vin);
                vehicles.add(vehicleEntity);
                CodeEntity codeEntity = new CodeEntity(code, isHardware);
                codes.add(codeEntity);
                VehicleCodeKey vehicleCodeKey = new VehicleCodeKey(vehicleEntity, codeEntity);
                vehicleCodes.add(new VehicleCodesEntity(vehicleCodeKey));
            }
            saveBatch(fileName, vehicles, codes, vehicleCodes);
            LOG.debug("Finished reading file {}", fileName);

        } catch (IOException e) {
            LOG.error("Could not read file {}.", filePath, e);
        }
    }

    //TODO: take care of duplicate entries
    private void saveBatch(final String fileName,
                           final HashSet<VehicleEntity> vehicles,
                           final HashSet<CodeEntity> codes,
                           final List<VehicleCodesEntity> vehicleCodes) {
        LOG.debug("Inserting {} lines of file {}", vehicleCodes.size(), fileName);
        vehicleRepository.saveAll(vehicles);
        codeRepository.saveAll(codes);
        vehicleCodesRepository.saveAll(vehicleCodes);
        LOG.debug("Finished inserting lines of file {}", vehicleCodes.size());
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
