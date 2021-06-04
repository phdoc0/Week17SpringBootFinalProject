package com.promineotech.dealerships.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int vehicleID;
    private int locationID;
    private boolean is_sold;
    private String make;
    private String model;
    private double price;
}
