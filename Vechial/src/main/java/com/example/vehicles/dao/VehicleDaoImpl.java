package com.example.vehicles.dao;

import com.example.vehicles.DatabaseOperations;
import com.example.vehicles.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    private final DatabaseOperations dbOps;

    public VehicleDaoImpl(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    @Override
    public void save(Vehicle vehicle) {
        try {
            Connection conn = dbOps.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO vehicles (brand, model, type) VALUES (?, ?, ?)");
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        try {
            Connection conn = dbOps.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE vehicles SET brand=?, model=?, type=? WHERE id=?");
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getType());
            stmt.setInt(4, vehicle.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = dbOps.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM vehicles WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vehicle searchById(int id) {
        try {
            Connection conn = dbOps.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vehicles WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vehicle v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setBrand(rs.getString("brand"));
                v.setModel(rs.getString("model"));
                v.setType(rs.getString("type"));
                return v;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        try {
            Connection conn = dbOps.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vehicles");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setBrand(rs.getString("brand"));
                v.setModel(rs.getString("model"));
                v.setType(rs.getString("type"));
                list.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
