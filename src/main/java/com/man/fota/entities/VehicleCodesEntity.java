package com.man.fota.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity(name = "vehicle_codes")
public class VehicleCodesEntity {

    @EmbeddedId
    private VehicleCodeKey vehicleCodeKey;
    @Version
    private Long version;

    public VehicleCodesEntity() {
    }

    public VehicleCodesEntity(final VehicleCodeKey vehicleCodeKey) {
        this.vehicleCodeKey = vehicleCodeKey;
    }

    public VehicleCodeKey getVehicleCodeKey() {
        return vehicleCodeKey;
    }

    public void setVehicleCodeKey(final VehicleCodeKey vehicleCodeKey) {
        this.vehicleCodeKey = vehicleCodeKey;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }
}
