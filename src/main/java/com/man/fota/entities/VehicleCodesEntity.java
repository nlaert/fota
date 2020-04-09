package com.man.fota.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "vehicle_codes")
public class VehicleCodesEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String vin;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCodesEntity that = (VehicleCodesEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getVin(), that.getVin()) &&
                Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVin(), getCode());
    }
}
