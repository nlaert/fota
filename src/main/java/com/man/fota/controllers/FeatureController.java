package com.man.fota.controllers;

import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.services.FeatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("features")
@RestController
public class FeatureController {

    final FeatureService featureService;

    public FeatureController(final FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("/{feature}/installable")
    public ResponseEntity<List<VehicleEntity>> getCompatibleVehicles(@PathVariable String feature) {
        return ResponseEntity.ok(featureService.getCompatibleVehicles(feature));
    }
    @GetMapping("/{feature}/incompatible")
    public ResponseEntity<List<VehicleEntity>> getIncompatibleVehicles(@PathVariable String feature) {
        return ResponseEntity.ok(featureService.getIncompatibleVehicles(feature));
    }
    @GetMapping("/{feature}")
    public ResponseEntity<List<VehicleEntity>> getAllVehiclesByFeature(@PathVariable String feature) {
        return ResponseEntity.ok(featureService.getAllVehicles(feature));
    }
    @GetMapping("/")
    public ResponseEntity<List<FeatureEntity>> getCompatibleVehicles() {
        return ResponseEntity.ok(featureService.getAllFeatures());
    }

}
