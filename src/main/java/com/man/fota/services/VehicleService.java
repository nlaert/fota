package com.man.fota.services;

import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleEntity;

import java.util.List;

public interface VehicleService {
    List<FeatureEntity> getInstallableFeaturesByVehicle(String vin);

    List<FeatureEntity> getIncompatibleFeaturesByVehicle(String vin);

    List<FeatureEntity> getAllFeaturesByVehicle(String vin);

    List<VehicleEntity> getAll();
}
