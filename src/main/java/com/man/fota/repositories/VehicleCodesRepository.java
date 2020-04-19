package com.man.fota.repositories;

import com.man.fota.entities.VehicleCodeKey;
import com.man.fota.entities.VehicleCodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleCodesRepository extends JpaRepository<VehicleCodesEntity, VehicleCodeKey> {

    @Modifying
    @Query(value = "insert into vehicle_codes values (:vehicleCodes) ON CONFLICT DO NOTHING",
            nativeQuery = true)
    void insertAllIfNotExists(@Param("vehicleCodes") List<VehicleCodesEntity> vehicleCodes);
}
