package com.man.fota.repositories;

import com.man.fota.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    @Query("select v from vehicles v " +
            "left join vehicle_codes vc " +
            "left join codes c " +
            "left join feature_codes fc " +
            "where (fc.isRequired = :isRequired or :isRequired is null) " + //TODO: not sure about the is null on Boolean
            "and fc.featureCodeKey.featureName = :name")
    List<VehicleEntity> getVehiclesByFeature(@Param("name") String name,
                                             @Param("isRequired") Boolean isRequired);

}
