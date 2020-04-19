package com.man.fota.repositories;

import com.man.fota.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    @Query("select v from vehicles v " +
            "left join vehicle_codes vc on vc.vehicleCodeKey.vehicle = v " +
            "left join codes c on vc.vehicleCodeKey.code = c " +
            "left join feature_codes fc on fc.featureCodeKey.code = c " +
            "where fc.isRequired = :isRequired " +
            "and fc.featureCodeKey.featureName.name = :name")
    List<VehicleEntity> getVehiclesByFeature(@Param("name") String name,
                                             @Param("isRequired") Boolean isRequired);

    @Query("select v from vehicles v " +
            "left join vehicle_codes vc on vc.vehicleCodeKey.vehicle = v " +
            "left join codes c on vc.vehicleCodeKey.code = c " +
            "left join feature_codes fc on fc.featureCodeKey.code = c " +
            "where fc.featureCodeKey.featureName.name = :name")
    List<VehicleEntity> getAllVehiclesByFeature(@Param("name") String name);

}
