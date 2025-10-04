package com.example.vehicles.dao;

import com.example.vehicles.model.Vehicle;

import java.util.List;

public interface VehicleDao<T> {
    void save(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(int id);
    Vehicle searchById(int id);
    List<Vehicle> getAllVehicles();
}
