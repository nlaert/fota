package com.man.fota.controllers;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;
import com.man.fota.services.FeatureService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("features")
@RestController
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(final FeatureService featureService) {
        this.featureService = featureService;
    }

    @ApiOperation(value = "Find installable VIN's by feature code", notes = "gives all the vins that can install the corresponding feature", response = VehicleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = VehicleDto.class),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/{feature}/installable")
    public ResponseEntity<List<VehicleDto>> getCompatibleVehicles(@PathVariable String feature) {
        return ResponseEntity.ok(featureService.getCompatibleVehicles(feature));
    }

    @ApiOperation(value = "Find incompatible VIN's by feature code", notes = "gives all the vins that cannot install the corresponding feature", response = VehicleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = VehicleDto.class),
            @ApiResponse(code = 404, message = "Not found")})

    @GetMapping("/{feature}/incompatible")
    public ResponseEntity<List<VehicleDto>> getIncompatibleVehicles(@PathVariable String feature) {
        return ResponseEntity.ok(featureService.getIncompatibleVehicles(feature));
    }

    @ApiOperation(value = "Find all VIN's by feature code", notes = "gives all the vins that can install the corresponding feature", response = VehicleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = AllValues.class),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/{feature}")
    public ResponseEntity<AllValues<VehicleDto>> getAllVehiclesByFeature(@PathVariable String feature) {
        return ResponseEntity.ok(featureService.getAllVehicles(feature));
    }

    @ApiOperation(value = "Find all features", notes = "returns a list of all feature codes", response = FeatureDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = FeatureDto.class)})
    @GetMapping("/")
    public ResponseEntity<List<FeatureDto>> getAllFeatures() {
        return ResponseEntity.ok(featureService.getAllFeatures());
    }

}
