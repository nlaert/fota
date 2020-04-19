package com.man.fota.services;

import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;
    private final VehicleRepository vehicleRepository;

    public FeatureServiceImpl(final FeatureRepository featureRepository, final VehicleRepository vehicleRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleEntity> getCompatibleVehicles(String name) {
        return vehicleRepository.getVehiclesByFeature(name, true);
    }

    @Override
    public List<VehicleEntity> getIncompatibleVehicles(String name) {
        return vehicleRepository.getVehiclesByFeature(name, false);
    }

    @Override
    public List<VehicleEntity> getAllVehicles(String name) {
        return vehicleRepository.getAllVehiclesByFeature(name);
    }

    @Override
    public List<FeatureEntity> getAllFeatures() {
        return featureRepository.findAll();
    }
}
