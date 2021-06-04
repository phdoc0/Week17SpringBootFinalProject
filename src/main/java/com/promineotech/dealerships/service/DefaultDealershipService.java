package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.dao.CustomerDao;
import com.promineotech.dealerships.dao.LocationDao;
import com.promineotech.dealerships.dao.EmployeeDao;
import com.promineotech.dealerships.dao.TransactionDao;
import com.promineotech.dealerships.dao.VehicleDao;
import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Employee;
import com.promineotech.dealerships.entity.Location;
import com.promineotech.dealerships.entity.Transaction;
import com.promineotech.dealerships.entity.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDealershipService implements DealershipService{
    
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private VehicleDao vehicleDao;
    
    //==========================Customers===============================================

    @Override
    public List<Customer> listCustomers(){
        return customerDao.listAllCustomers();
    }
   
	@Override
    public void newCustomer(String name, String address, String phone) {
        customerDao.newCustomer(name, address, phone);        
    }

    @Override
    public void updateCustomer(int customerID, String name, String address, String phone){
        customerDao.updateCustomer(customerID, name, address, phone);
    }

    @Override
     public void deleteCustomer(int customerID){
        customerDao.deleteCustomer(customerID);
    }
    


    //==========================Transactions===============================================

    public List<Transaction> getTransactions(int transactionID){
       return transactionDao.getTransaction(transactionID);
    }

    @Override
    public void deleteTransaction(int transactionID) {
        transactionDao.deleteTransaction(transactionID);
    }

    @Override
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeID, int locationID,
            String date) {
        transactionDao.updateTransaction(transactionID, vehicleID, customerID, employeeID, locationID, date);
    }

    @Override
    public void newTransaction(int vehicleID, int customerID, int employeeID, int locationID, String date) {
    	//Vehicle car = vehicleDao.getVehicle(vehicleID).get(0);
        //vehicleDao.updateVehicle(vehicleID, car.getLocationID(), true, car.getMake(), car.getModel(), car.getPrice());
        transactionDao.newTransaction(vehicleID, customerID, employeeID, locationID, date);        
    }


//==========================Locations===============================================
    
public List<Location> getLocation(int locationID){
    return locationDao.getLocation(locationID);
 }

 @Override
 public void deleteLocation(int locationID) {
	 locationDao.deleteLocation(locationID);
 }

 @Override
 public void updateLocation(int locationID, String locationName) {
	 locationDao.updateLocation(locationID, locationName);
     
 }

 @Override
 public void newLocation(String locationName) {
     locationDao.newLocation(locationName);        
 }
 
//==========================Employees===============================================

 @Override
 public List<Employee> listEmployees(){
     return employeeDao.listAllEmployees();
 }

	@Override
 public void newEmployee(String name, int locationID) {
     employeeDao.newEmployee( name, locationID);        
 }

 @Override
 public void updateEmployee(int customerID, String name, int locationID){
	 employeeDao.updateEmployee(customerID, name, locationID);
 }

 @Override
  public void deleteEmployee(int customerID){
	 employeeDao.deleteEmployee(customerID);
 }
 

//============================vehicle==========================================
 
public List<Vehicle> getVehicle(int vehicleID){
    return vehicleDao.getVehicle(vehicleID);

}
@Override
public void deleteVehicle(int vehicleID) {
    vehicleDao.deleteVehicle(vehicleID);
}

@Override
public void updateVehicle(int vehicleID, int locationID, boolean is_sold, String make, String model, double price) {
    vehicleDao.updateVehicle(vehicleID, locationID, is_sold, make, model, price);

}

@Override
public void newVehicle(int locationID, boolean is_sold, String make, String model, double price) {
    vehicleDao.newVehicle(locationID, is_sold, make, model, price);
}
 
 
}// end DefaultDealershipService class
