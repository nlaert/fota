package com.man.fota.services;

import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleEntity;

import java.util.List;

public interface FeatureService {

    List<VehicleEntity> getCompatibleVehicles(String name);

    List<VehicleEntity> getIncompatibleVehicles(String name);

    List<VehicleEntity> getAllVehicles(String name);

    List<FeatureEntity> getAllFeatures();
}
