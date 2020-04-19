package com.man.fota.repositories;

import com.man.fota.entities.VehicleCodeKey;
import com.man.fota.entities.VehicleCodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCodesRepository extends JpaRepository<VehicleCodesEntity, VehicleCodeKey> {
}
