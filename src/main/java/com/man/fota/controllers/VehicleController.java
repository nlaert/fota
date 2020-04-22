package com.man.fota.controllers;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;
import com.man.fota.services.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("vehicles")
@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ApiOperation(value = "Find installable features by VIN", notes = "gives all the features that can be installed for the corresponding vin", response = FeatureDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = FeatureDto.class),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/{vin}/installable")
    public ResponseEntity<List<FeatureDto>> getInstallableFeatures(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getInstallableFeaturesByVehicle(vin));
    }

    @ApiOperation(value = "Find incompatible features by VIN", notes = "gives all the features that cannot be installed for the corresponding vin", response = FeatureDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = FeatureDto.class),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/{vin}/incompatible")
    public ResponseEntity<List<FeatureDto>> getIncompatibleFeatures(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getIncompatibleFeaturesByVehicle(vin));
    }

    @ApiOperation(value = "Find all features by VIN", notes = "gives all features that can/cannot be installed for the corresponding vin", response = AllValues.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = AllValues.class),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/{vin}")
    public ResponseEntity<AllValues<FeatureDto>> getFeaturesByVehicle(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getAllFeaturesByVehicle(vin));
    }

    @ApiOperation(value = "Find all vehicles", notes = "returns a list of all vehicles", response = VehicleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = VehicleDto.class)})
    @GetMapping("/")
    public ResponseEntity<List<VehicleDto>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }
}
