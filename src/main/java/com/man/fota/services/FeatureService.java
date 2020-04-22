package com.man.fota.services;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;

import java.util.List;

public interface FeatureService {

    /**
     * Gets all vehicles in which the given feature can be installed.
     *
     * @param name the feature name
     * @return a list of vehicles that are compatible with the feature.
     */
    List<VehicleDto> getCompatibleVehicles(String name);

    /**
     * Gets all vehicles in which the given feature can't be installed.
     *
     * @param name the feature name
     * @return a list of vehicles that are incompatible with the feature.
     */
    List<VehicleDto> getIncompatibleVehicles(String name);

    /**
     * Gets all vehicles in which the given feature can or can not be installed.
     *
     * @param name the feature name
     * @return a list of vehicles that are compatible/incompatible with the feature.
     */
    AllValues<VehicleDto> getAllVehicles(String name);

    /**
     * Gets all features
     *
     * @return a List of features
     */
    List<FeatureDto> getAllFeatures();
}
