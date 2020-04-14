package com.man.fota.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleCodesRepository;
import com.man.fota.repositories.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleServiceImpl.class);

    private final VehicleRepository vehicleRepository;
    private final VehicleCodesRepository vehicleCodesRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public VehicleServiceImpl(final FeatureRepository featureRepository,
                              final VehicleRepository vehicleRepository,
                              final VehicleCodesRepository vehicleCodesRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
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
    public void processNewFile(final String filePath) {
        BufferedReader fileReader = null;
        try {
            List<VehicleCodesEntity> vehicleCodesEntities = readFile(filePath);
            List<VehicleEntity> vehicles = vehicleCodesEntities.stream()
                    .distinct()
                    .map(vehicleCodesEntity -> new VehicleEntity(vehicleCodesEntity.getVin()))
                    .collect(Collectors.toList());

            vehicleRepository.saveAll(vehicles);
            vehicleCodesRepository.saveAll(vehicleCodesEntities);
        } catch (IOException e) {
            LOG.error("Could not read file {}.", filePath, e);
        }
    }

    private List<VehicleCodesEntity> readFile(String filePath) throws IOException {
        CsvMapper mapper = new CsvMapper();
//        CsvSchema csvSchema = mapper.schemaFor(VehicleCodesEntity.class);
        File file = new File(filePath); //TODO check if needed new ClassPathResource(fileName).getFile();
        MappingIterator<VehicleCodesEntity> mappingIterator = mapper.readerFor(VehicleCodesEntity.class).readValues(file);
        return mappingIterator.readAll();
    }


}
