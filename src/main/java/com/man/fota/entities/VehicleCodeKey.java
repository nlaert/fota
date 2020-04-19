package com.man.fota.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VehicleCodeKey implements Serializable {

    @JoinColumn(name = "vehicle")
    @ManyToMany
    private VehicleEntity vehicle;

    @JoinColumn(name = "code")
    @ManyToMany
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCodeKey that = (VehicleCodeKey) o;
        return Objects.equals(getVehicle(), that.getVehicle()) &&
                Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicle(), getCode());
    }
}
