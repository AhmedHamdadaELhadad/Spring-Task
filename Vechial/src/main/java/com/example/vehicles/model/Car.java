package com.example.vehicles.model;

import com.example.vehicles.DatabaseOperations;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@Scope("prototype")
public class Car extends  Vehicle {
    private final DatabaseOperations db;

    public Car(DatabaseOperations db) {
        this.db = db;
        setType("Car");
    }
}
