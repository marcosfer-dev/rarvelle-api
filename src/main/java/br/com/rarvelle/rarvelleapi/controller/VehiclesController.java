package br.com.rarvelle.rarvelleapi.controller;

import br.com.rarvelle.rarvelleapi.service.VehicleService;
import br.com.rarvelle.rarvelleapi.veiculo.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> listsVehicles() {
        return vehicleService.listActiveVehicles();
    }

    @PostMapping
    public ResponseEntity<Vehicle> registerVehicles(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

}