package com.man.fota.repositories;

import com.man.fota.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, String> {

    @Query("select f from features f " +
            "left join feature_codes fc " +
            "left join codes c " +
            "left join vehicle_codes vc " +
            "where (fc.isRequired = :isRequired or :isRequired is null) " + //TODO: not sure about the is null on Boolean
            "and vc.vin = :vin")
    List<FeatureEntity> getFeaturesByVin(@Param("vin") String vin,
                                         @Param("isRequired") Boolean isRequired);
}
