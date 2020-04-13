package com.man.fota.controllers;

import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.services.FeatureService;
import com.man.fota.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequestMapping("vehicles")
@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{vin}/installable")
    public ResponseEntity<List<FeatureEntity>> getInstallableFeatures(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getInstallableFeaturesByVehicle(vin));
    }


    @GetMapping("/{vin}/incompatible")
    public ResponseEntity<List<FeatureEntity>> getIncompatibleFeatures(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getIncompatibleFeaturesByVehicle(vin));
    }

    @GetMapping("/{vin}")
    public ResponseEntity<List<FeatureEntity>> getFeaturesByVehicle(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getAllFeaturesByVehicle(vin));
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleEntity>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }
}
