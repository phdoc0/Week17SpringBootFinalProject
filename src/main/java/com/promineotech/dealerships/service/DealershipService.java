package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Employee;
import com.promineotech.dealerships.entity.Location;
import com.promineotech.dealerships.entity.Transaction;
import com.promineotech.dealerships.entity.Vehicle;

public interface DealershipService {

    /**
     * Customer Functions 
     * @return
     */

    List<Customer> listCustomers();
    void updateCustomer(int customerID, String name, String address, String phone);
    void newCustomer(String name, String address, String phone);
    void deleteCustomer(int customerID);

    /**
     * Transaction Functions 
     * @param transactionID
     * @return
     */

    public List<Transaction> getTransactions(int transactionID);
    public void deleteTransaction(int transactionID);
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeID, int locationID, String date);
    public void newTransaction(int vehicleID, int customerID, int employeeID, int locationID, String date);
	
	
    /**
     * Location Functions 
     * @param locationID
     * @return
     */

    public List<Location> getLocation(int locationID);
    public void deleteLocation(int locationID);
    public void updateLocation(int locationID, String locationName);
    public void newLocation(String locationName);
	
    
    /**
     * Empolyee Functions 
     * @return
     */

    List<Employee> listEmployees();
    void updateEmployee(int customerID, String name, int locationID);
    void newEmployee(String name, int locationID);
    void deleteEmployee(int customerID);
    

    /**
     * Vehicle Functions
     * @param VehicleID
     * @return
     */

    public List<Vehicle> getVehicle(int vehicleID);
    public void deleteVehicle(int vehicleID);
    public void updateVehicle(int vehicleID, int locationID, boolean is_sold, String make, String model, double price);
    public void newVehicle(int locationID, boolean is_sold, String make, String model, double price);
}
