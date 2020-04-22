package com.man.fota.repositories;

import com.man.fota.entities.CodeEntity;
import com.man.fota.entities.VehicleCodeKey;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCodesRepository extends JpaRepository<VehicleCodesEntity, VehicleCodeKey> {

    @Modifying
    @Query(value = "insert into vehicle_codes (vehicle, code, version) values (:vehicle, :code, 0) ON CONFLICT DO NOTHING",
            nativeQuery = true)
    void insertIfNotExists(@Param("vehicle") VehicleEntity vehicles,
                           @Param("code") CodeEntity codes);
}
