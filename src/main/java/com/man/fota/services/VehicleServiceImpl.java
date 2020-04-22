package com.man.fota.services;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;
import com.man.fota.entities.CodeEntity;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.repositories.CodeRepository;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleCodesRepository;
import com.man.fota.repositories.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleServiceImpl.class);

    private final VehicleRepository vehicleRepository;
    private final CodeRepository codeRepository;
    private final VehicleCodesRepository vehicleCodesRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public VehicleServiceImpl(final VehicleRepository vehicleRepository,
                              final CodeRepository codeRepository,
                              final VehicleCodesRepository vehicleCodesRepository,
                              final FeatureRepository featureRepository) {
        this.vehicleRepository = vehicleRepository;
        this.codeRepository = codeRepository;
        this.vehicleCodesRepository = vehicleCodesRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public List<FeatureDto> getInstallableFeaturesByVehicle(String vin) {
        return featureRepository.getInstallableFeaturesByVin(vin).stream()
                .map(f -> new FeatureDto(f.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<FeatureDto> getIncompatibleFeaturesByVehicle(String vin) {
        return featureRepository.getIncompatibleFeaturesByVin(vin).stream()
                .map(f -> new FeatureDto(f.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public AllValues<FeatureDto> getAllFeaturesByVehicle(String vin) {
        AllValues<FeatureDto> allValues = new AllValues<>();
        allValues.setInstallable(getInstallableFeaturesByVehicle(vin));
        allValues.setIncompatible(getIncompatibleFeaturesByVehicle(vin));
        return allValues;
    }

    @Override
    public List<VehicleDto> getAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicleEntity -> new VehicleDto(vehicleEntity.getVin()))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void saveBatch(final String fileName,
                          final Set<VehicleEntity> vehicles,
                          final Set<CodeEntity> codes,
                          final List<VehicleCodesEntity> vehicleCodes) {
        removeDuplicates(vehicles, codes);
        LOG.debug("Inserting {} lines of file {}", vehicleCodes.size(), fileName);
        vehicleRepository.saveAll(vehicles);
        codeRepository.saveAll(codes);
        vehicleCodes.forEach(vehicleCodesEntity ->
                vehicleCodesRepository.insertIfNotExists(vehicleCodesEntity.getVehicleCodeKey().getVehicle(),
                        vehicleCodesEntity.getVehicleCodeKey().getCode()));
        LOG.debug("Finished inserting lines of file {}", vehicleCodes.size());
    }

    @Override
    public void removeDuplicates(final Set<VehicleEntity> vehicles,
                                 final Set<CodeEntity> codes) {
        vehicles.removeAll(vehicleRepository.findAllById(vehicles.stream()
                .map(VehicleEntity::getVin).collect(Collectors.toList())));
        codes.removeAll(codeRepository.findAllById(codes.stream()
                .map(CodeEntity::getCode).collect(Collectors.toList())));
    }
}
