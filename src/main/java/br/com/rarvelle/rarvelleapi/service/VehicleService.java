package br.com.rarvelle.rarvelleapi.service;

import br.com.rarvelle.rarvelleapi.veiculo.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
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

}