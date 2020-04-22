package com.man.fota.services;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;
    private final VehicleRepository vehicleRepository;

    public FeatureServiceImpl(final FeatureRepository featureRepository,
                              final VehicleRepository vehicleRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> getCompatibleVehicles(String name) {
        return vehicleRepository.getInstallableVehiclesByFeature(name).stream()
                .map(vehicleEntity -> new VehicleDto(vehicleEntity.getVin()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getIncompatibleVehicles(String name) {
        return vehicleRepository.getIncompatibleVehiclesByFeature(name).stream()
                .map(vehicleEntity -> new VehicleDto(vehicleEntity.getVin()))
                .collect(Collectors.toList());
    }

    @Override
    public AllValues<VehicleDto> getAllVehicles(String name) {
        AllValues<VehicleDto> allValues = new AllValues<>();
        allValues.setInstallable(getCompatibleVehicles(name));
        allValues.setIncompatible(getIncompatibleVehicles(name));
        return allValues;
    }

    @Override
    public List<FeatureDto> getAllFeatures() {
        return featureRepository.findAll().stream()
                .map(featureEntity -> new FeatureDto(featureEntity.getName()))
                .collect(Collectors.toList());
    }
}
