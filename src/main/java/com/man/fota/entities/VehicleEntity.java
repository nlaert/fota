package com.man.fota.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "vehicles")
public class VehicleEntity {

    @Id
    private String vin;

    protected VehicleEntity() {
    }

    public VehicleEntity(final String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return Objects.equals(getVin(), that.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin());
    }
}
