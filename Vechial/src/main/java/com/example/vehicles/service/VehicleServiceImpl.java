package com.example.vehicles.service;

import com.example.vehicles.dao.VehicleDao;
import com.example.vehicles.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleDao vehicleDao;

    public VehicleServiceImpl(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        vehicleDao.update(vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        vehicleDao.delete(id);
    }

    @Override
    public Vehicle searchById(int id) {
        return vehicleDao.searchById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }
}
