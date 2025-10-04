package com.example.vehicles.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String type;
}
