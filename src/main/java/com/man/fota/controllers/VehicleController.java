package com.man.fota.controllers;

import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
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

    @GetMapping("/{vin}/installable")//TODO
    public ResponseEntity<?> getVehicle(@PathVariable String vin) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/") //TODO
    public ResponseEntity<List<VehicleEntity>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }
}
