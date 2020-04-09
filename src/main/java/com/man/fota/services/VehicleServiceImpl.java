package com.man.fota.services;

import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public VehicleServiceImpl(final FeatureRepository featureRepository, final VehicleRepository vehicleRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
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


}
