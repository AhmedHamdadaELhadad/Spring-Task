package com.example.vehicles.Controller;

import com.example.vehicles.model.Vehicle;
import com.example.vehicles.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public String addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "Vehicle saved!";
    }

    @PutMapping("/{id}")
    public String updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        vehicle.setId(id);
        vehicleService.updateVehicle(vehicle);
        return "Vehicle updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return "Vehicle deleted!";
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable int id) {
        return vehicleService.searchById(id);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}

