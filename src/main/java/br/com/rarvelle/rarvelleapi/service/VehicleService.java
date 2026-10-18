package br.com.rarvelle.rarvelleapi.service;

import br.com.rarvelle.rarvelleapi.dto.CreateVehicleRequest;
import br.com.rarvelle.rarvelleapi.vehicle.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle addVehicle(CreateVehicleRequest createVehicleRequest){
        var vehicle = new Vehicle(
                createVehicleRequest.model(),
                createVehicleRequest.version(),
                createVehicleRequest.price(),
                createVehicleRequest.active()
        );

        vehicles.add(vehicle);

        return vehicle;
    }

    public List<Vehicle> listVehicles() {
        return vehicles;
    }

    public List<Vehicle> listActiveVehicles() {
        List<Vehicle> activeVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.isActive()) {
                activeVehicles.add(vehicle);
            }
        }

        return activeVehicles;
    }

    public Optional<Vehicle> findVehicleById(UUID id) {

        for (Vehicle vehicle : vehicles) {
            if (id.equals(vehicle.getId())) {
                return Optional.of(vehicle);
            }
        }

        return Optional.empty();

    }

}