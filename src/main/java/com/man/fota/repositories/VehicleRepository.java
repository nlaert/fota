package com.man.fota.repositories;

import com.man.fota.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    @Query("select distinct v from vehicles v " +
            "inner join vehicle_codes vc on vc.vehicleCodeKey.vehicle = v " +
            "inner join feature_codes fc on fc.featureCodeKey.code = vc.vehicleCodeKey.code " +
            "where fc.isRequired = true " +
            "and fc.featureCodeKey.featureName.name = :name " +
            "and v not in (" +
            "               select v1 from vehicles v1 " +
            "               inner join vehicle_codes vc1 on vc1.vehicleCodeKey.vehicle = v1 " +
            "               inner join feature_codes fc1 on fc1.featureCodeKey.code = vc1.vehicleCodeKey.code " +
            "               where fc1.isRequired = false" +
            "               and fc1.featureCodeKey.featureName.name = :name)")
    List<VehicleEntity> getInstallableVehiclesByFeature(@Param("name") String name);

    @Query("select v from vehicles v " +
            "inner join vehicle_codes vc on vc.vehicleCodeKey.vehicle = v " +
            "inner join feature_codes fc on fc.featureCodeKey.code = vc.vehicleCodeKey.code " +
            "where fc.isRequired = false " +
            "and fc.featureCodeKey.featureName.name = :name ")
    List<VehicleEntity> getIncompatibleVehiclesByFeature(@Param("name") String name);

}
