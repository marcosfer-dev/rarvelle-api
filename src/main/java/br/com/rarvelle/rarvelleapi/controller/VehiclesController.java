package br.com.rarvelle.rarvelleapi.controller;

import br.com.rarvelle.rarvelleapi.dto.CreateVehicleRequest;
import br.com.rarvelle.rarvelleapi.service.VehicleService;
import br.com.rarvelle.rarvelleapi.veiculo.Vehicle;
import jakarta.validation.Valid;
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
    public List<Vehicle> listsVehiclesActives() {
        return vehicleService.listActiveVehicles();
    }

    @PostMapping
    public ResponseEntity<Vehicle> registerVehicles(@RequestBody @Valid CreateVehicleRequest createVehicleRequest) {
        var vehicle = vehicleService.addVehicle(createVehicleRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

}