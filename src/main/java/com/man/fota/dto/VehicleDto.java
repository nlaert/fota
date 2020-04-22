package com.man.fota.dto;

import java.util.Objects;

public class VehicleDto {
    private String vin;

    public VehicleDto(final String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(final String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDto that = (VehicleDto) o;
        return Objects.equals(getVin(), that.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin());
    }
}
