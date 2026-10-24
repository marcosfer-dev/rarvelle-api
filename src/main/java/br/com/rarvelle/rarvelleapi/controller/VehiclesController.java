package br.com.rarvelle.rarvelleapi.controller;

import br.com.rarvelle.rarvelleapi.dto.CreateVehicleRequest;
import br.com.rarvelle.rarvelleapi.dto.UpdateVehicleRequest;
import br.com.rarvelle.rarvelleapi.dto.UpdateVehiclePriceRequest;
import br.com.rarvelle.rarvelleapi.dto.UpdateVehicleStatusRequest;
import br.com.rarvelle.rarvelleapi.service.VehicleService;
import br.com.rarvelle.rarvelleapi.vehicle.Vehicle;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> listsVehiclesActives() {
        return vehicleService.listActiveVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> listVehicleId(@PathVariable UUID id) {
        var vehicle = vehicleService.findVehicleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(vehicle);
    }

    @PostMapping
    public ResponseEntity<Vehicle> registerVehicles(@RequestBody @Valid CreateVehicleRequest createVehicleRequest) {
        var vehicle = vehicleService.addVehicle(createVehicleRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<Void> updateVehiclePrice(@PathVariable UUID id, @RequestBody @Valid UpdateVehiclePriceRequest request) {
        vehicleService.updateVehiclePrice(id, request);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Void> updateVehicleStatus(@PathVariable UUID id, @RequestBody UpdateVehicleStatusRequest request) {
        vehicleService.updateVehicleStatus(id, request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVehicle(@PathVariable UUID id, @RequestBody @Valid UpdateVehicleRequest request) {
        vehicleService.updateVehicle(id, request);

        return ResponseEntity.noContent().build();
    }

}