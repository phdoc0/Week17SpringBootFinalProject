package com.promineotech.dealerships.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int transactionID;
    private int vehicleID;
    private int customerID;
    private int employeeID;
    private int locationID;
    private String dateStamp;
}
