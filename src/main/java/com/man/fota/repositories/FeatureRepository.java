package com.man.fota.repositories;

import com.man.fota.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeatureRepository extends JpaRepository<FeatureEntity, String> {

    @Query("select distinct f from features f " +
            "inner join feature_codes fc on fc.featureCodeKey.featureName = f " +
            "inner join vehicle_codes vc on vc.vehicleCodeKey.code = fc.featureCodeKey.code " +
            "where vc.vehicleCodeKey.vehicle.vin = :vin " +
            "and fc.isRequired = true " +
            "and fc.featureCodeKey.featureName not in " +
            "               (select fc1.featureCodeKey.featureName from feature_codes fc1 " +
            "               inner join vehicle_codes vc1 on vc1.vehicleCodeKey.code = fc1.featureCodeKey.code " +
            "               where vc1.vehicleCodeKey.vehicle.vin = :vin " +
            "               and fc1.isRequired = false)")
    List<FeatureEntity> getInstallableFeaturesByVin(@Param("vin") String vin);

    @Query("select distinct f from features f " +
            "inner join feature_codes fc on fc.featureCodeKey.featureName = f " +
            "inner join vehicle_codes vc on vc.vehicleCodeKey.code = fc.featureCodeKey.code " +
            "where vc.vehicleCodeKey.vehicle.vin = :vin " +
            "and fc.isRequired = false")
    List<FeatureEntity> getIncompatibleFeaturesByVin(@Param("vin") String vin);
}
