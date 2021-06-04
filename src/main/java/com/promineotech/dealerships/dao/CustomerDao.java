package com.promineotech.dealerships.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.promineotech.dealerships.entity.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/dealership?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password1";

    public List<Customer> listAllCustomers() {
        final String sql = "SELECT * FROM customers";

        try (
			Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				// create a car statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

			// execute the car query
			ResultSet rs = preparedStatement.executeQuery();
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
				int customerID = rs.getInt("customerID");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				Customer customer = new Customer(customerID, name, address, phone);
                list.add(customer);
			}
            return list;
        } catch (SQLException e) {
			printSQLException(e);
			System.out.println("test");
            return Collections.emptyList();
		} 
            
    }
    // Insert operation for customers table
    public void newCustomer(String name, String address, String phone) {
        final String sql = "insert into customers (name, address, phone) Values (?,?,?);";

        try (
			Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				// create a car statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, phone);

			    // execute the car query
			    preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
			printSQLException(e);
		} 
            
    }
    
    public void updateCustomer(int customerID, String name, String address, String phone) {
        final String sql = "update customers set name = ?, address = ? , phone = ? where customerID = ?;";

        try (
			Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				// create a car statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, phone);
                preparedStatement.setInt(4, customerID);

			    // execute the car query
			    preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
			printSQLException(e);
		} 
            
    }

	// Delete Operation for Customers Table
    
    public void deleteCustomer(int customerID) {
        final String sql = "delete from customers where customerID = ?;";

        try (
			Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				// create a customer delete statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

                preparedStatement.setInt(1, customerID);

			    // execute the car query
			    preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
			printSQLException(e);
		} 
            
    }




    public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
    
}
