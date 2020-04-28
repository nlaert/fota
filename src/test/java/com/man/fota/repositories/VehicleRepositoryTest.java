package com.man.fota.repositories;

import com.man.fota.entities.VehicleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldReturnCompatibleWithXWhenGivenX() {
        List<VehicleEntity> vehicles = vehicleRepository.getInstallableVehiclesByFeature("X");
        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("compatibleFeatureX", vehicles.get(0).getVin());
    }

    @Test
    public void shouldReturnIncompatibleWithXWhenGivenX() {
        List<VehicleEntity> vehicles = vehicleRepository.getIncompatibleVehiclesByFeature("X");
        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("incompatibleFeatureX", vehicles.get(0).getVin());
    }

    @Test
    public void shouldReturnCompatibleFeatureYAndZWhenGivenZ() {
        List<VehicleEntity> vehicles = vehicleRepository.getInstallableVehiclesByFeature("Z");
        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("compatibleFeatureYAndZ", vehicles.get(0).getVin());
    }

    @Test
    public void shouldReturnCompatibleFeatureYAndZAndCompatibleFeatureYIncompatibleZWhenGivenY() {
        List<VehicleEntity> vehicles = vehicleRepository.getInstallableVehiclesByFeature("Y");
        VehicleEntity YAndZVehicle = new VehicleEntity("compatibleFeatureYAndZ");
        VehicleEntity YVehicle = new VehicleEntity("compatibleFeatureYIncompatibleZ");

        Assertions.assertTrue(vehicles.contains(YVehicle));
        Assertions.assertTrue(vehicles.contains(YAndZVehicle), "Should return compatibleFeatureYAndZ");
    }
}