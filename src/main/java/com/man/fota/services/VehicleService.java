package com.man.fota.services;

import com.man.fota.entities.CodeEntity;
import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;

import java.util.List;
import java.util.Set;

public interface VehicleService {
    List<FeatureEntity> getInstallableFeaturesByVehicle(String vin);

    List<FeatureEntity> getIncompatibleFeaturesByVehicle(String vin);

    List<FeatureEntity> getAllFeaturesByVehicle(String vin);

    List<VehicleEntity> getAll();

    void saveBatch(String fileName,
                   Set<VehicleEntity> vehicles,
                   Set<CodeEntity> codes,
                   List<VehicleCodesEntity> vehicleCodes);
}
