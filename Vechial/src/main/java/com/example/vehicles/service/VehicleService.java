package com.example.vehicles.service;

import com.example.vehicles.model.Vehicle;

import java.util.List;

public interface VehicleService {

    void saveVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void deleteVehicle(int id);
    Vehicle searchById(int id);
    List<Vehicle> getAllVehicles();
}
