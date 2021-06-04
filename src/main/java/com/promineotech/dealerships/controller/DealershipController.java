package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Employee;
import com.promineotech.dealerships.entity.Location;
import com.promineotech.dealerships.entity.Transaction;
import com.promineotech.dealerships.entity.Vehicle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/Dealerships")
public interface DealershipController {
    
    //==========================Customers===============================================

    /**
     * Customer Handlers
     * @return
     */
    @GetMapping("Customers")
    ResponseEntity<List<Customer>> listCustomers();
    
    // Insert customer
    @PostMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void newCustomer(
        @RequestParam(required = true) String name,
        @RequestParam(required = true) String address, 
        @RequestParam(required = true) String phone);

    @PutMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void updateCustomer(
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) String name,
        @RequestParam(required = true) String address, 
        @RequestParam(required = true) String phone);


    // Delete operation on customers table
    @DeleteMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteCustomer(
        @RequestParam(required = true) int customerID);

    //==========================Transactions===============================================

    /**
     * Transaction handlers 
     * @param transactionID
     * @return
     */
    @GetMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<Transaction>> getTransactions(
        @RequestParam(required = true) int transactionID
    );

    @DeleteMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteTransaction(
        @RequestParam(required = true) int transactionID
    );

    @PostMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void newTransaction( 
        @RequestParam(required = true) int vehicleID, 
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) int employeeID, 
        @RequestParam(required = true) int locationID, 
        @RequestParam(required = true) String date);

    @PutMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void updateTransaction(
        @RequestParam(required = true) int transactionID, 
        @RequestParam(required = true) int vehicleID, 
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) int employeeID, 
        @RequestParam(required = true) int locationID, 
        @RequestParam(required = true) String date);


//==========================Locations===============================================

/**
 * Location handlers 
 * @param locationID
 * @return
 */
@GetMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
ResponseEntity<List<Location>> getLocation(
    @RequestParam(required = true) int locationID
);

@DeleteMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void deleteLocation(
    @RequestParam(required = true) int locationID
);

@PostMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void newLocation( 
    @RequestParam(required = true) String locationName);

@PutMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void updateLocation(
    @RequestParam(required = true) int locationID, 
    @RequestParam(required = true) String locationName);

//==========================Employee===============================================


@GetMapping("Employees")
ResponseEntity<List<Employee>> listEmployees();


@PostMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void newEmployee(
    @RequestParam(required = true) String name,
    @RequestParam(required = true) int locationID);
   

@PutMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void updateEmployee(
    @RequestParam(required = true) int employeeID, 
    @RequestParam(required = true) String name,
    @RequestParam(required = true) int locationID);


@DeleteMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void deleteEmployee(
    @RequestParam(required = true) int employeeID);



//========================Vehicles========================================

  /**
   *  Vehicle handlers
   *  @param vehicleID
   *  @return
   */
  @GetMapping("Vehicles")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<Vehicle>> getVehicle(
          @RequestParam(required = true) int vehicleID
  );

  @DeleteMapping("Vehicles")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteVehicle(
          @RequestParam(required = true) int vehicleID);



  @PostMapping("Vehicles")
  @ResponseStatus(code = HttpStatus.OK)
  void newVehicle(
          @RequestParam(required = true) int locationID,
          @RequestParam(required = true) boolean is_sold,
          @RequestParam(required = true) String make,
          @RequestParam(required = true) String model,
          @RequestParam(required = true) double price);

  @PutMapping("Vehicles")
  @ResponseStatus(code = HttpStatus.OK)
  void updateVehicle(
          @RequestParam(required = true) int vehicleID,
          @RequestParam(required = true) int locationID,
          @RequestParam(required = true) boolean is_sold,
          @RequestParam(required = true) String make,
          @RequestParam(required = true) String model,
          @RequestParam(required = true) double price);

} // end DealershipController Interface



