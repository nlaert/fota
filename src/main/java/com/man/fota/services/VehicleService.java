package com.man.fota.services;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;
import com.man.fota.entities.CodeEntity;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;

import java.util.List;
import java.util.Set;

public interface VehicleService {

    /**
     * Gets a list of features that can be installed in the given vehicle.
     *
     * @param vin the Vehicle Identification Number to search for installable features.
     * @return all features that can be installed in the vehicle.
     */
    List<FeatureDto> getInstallableFeaturesByVehicle(String vin);

    /**
     * Gets a list of features that can't be installed in the given vehicle.
     *
     * @param vin the Vehicle Identification Number to search for incompatible features.
     * @return all features that can't be installed in the vehicle.
     */
    List<FeatureDto> getIncompatibleFeaturesByVehicle(String vin);

    /**
     * Gets all features that are installable or incompatible in the given vehicle.
     *
     * @param vin the Vehicle Identification Number to search for features.
     * @return all features that can or can not be installed in the vehicle.
     */
    AllValues<FeatureDto> getAllFeaturesByVehicle(String vin);

    /**
     * Gets a list with all the available vehicles.
     *
     * @return a list of vehicles
     */
    List<VehicleDto> getAll();

    /**
     * Saves the given vehicles, codes and makes the relation between them.
     *
     * @param fileName     the name of the file that is being processed.
     * @param vehicles     a set of vehicles to save.
     * @param codes        a set of codes to save.
     * @param vehicleCodes a list with the relation between vehicles and codes.
     */
    void saveBatch(String fileName,
                   Set<VehicleEntity> vehicles,
                   Set<CodeEntity> codes,
                   List<VehicleCodesEntity> vehicleCodes);

    /**
     * Queries the DB to check for duplicate and remove them from the sets.
     * NOTE: This will change the given lists.
     *
     * @param vehicles a set of vehicles to search for duplicates.
     * @param codes    a set of codes to search for duplicates.
     */
    void removeDuplicates(Set<VehicleEntity> vehicles,
                          Set<CodeEntity> codes);
}
