package com.man.fota.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VehicleCodeKey implements Serializable {

    @JoinColumn(name = "vehicle")
    @ManyToOne
    private VehicleEntity vehicle;

    @JoinColumn(name = "code")
    @ManyToOne
    private CodeEntity code;

    public VehicleCodeKey() {
    }

    public VehicleCodeKey(final VehicleEntity vehicle, final CodeEntity code) {
        this.vehicle = vehicle;
        this.code = code;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(final VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }

    public CodeEntity getCode() {
        return code;
    }

    public void setCode(final CodeEntity code) {
        this.code = code;
    }
}
