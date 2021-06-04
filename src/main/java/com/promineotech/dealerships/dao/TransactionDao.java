package com.promineotech.dealerships.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.promineotech.dealerships.entity.Transaction;

@Service
public class TransactionDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/dealership?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password1";

    
        public List<Transaction> getTransaction(Integer transactionID){
            final String getTransaction = "SELECT * FROM transactions where transactionID = ?;";

            try (
                    Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

                    // create a statement using connection object
                        PreparedStatement preparedStatement = connection.prepareStatement(getTransaction);
                        
                ) {
                    preparedStatement.setInt(1, transactionID);
                // execute the car query
                ResultSet rs = preparedStatement.executeQuery();
                List<Transaction> list = new ArrayList<>();
                while (rs.next()) {
                    int transaction_id = rs.getInt("transactionID");
                    int vehicleID = rs.getInt("vehicleID");
                    int customerID = rs.getInt("customerID");
                    int employeeID = rs.getInt("employeeID");
                    int locationID = rs.getInt("locationID");
                    String date = rs.getString("datestamp");
                    Transaction transaction = new Transaction(transaction_id, vehicleID, customerID, employeeID, locationID, date);
                    list.add(transaction);
                }
                return list;
            } catch (SQLException e) {
                printSQLException(e);
                return Collections.emptyList();
            } 
        }

        
        public void newTransaction(int vehicleID, int customerID, int employeeID, int locationID, 
            String date) {
             
            final String updateTransaction = "INSERT into transactions (vehicleID, customerID, employeeID, locationID, datestamp)" +
                "Values (?, ?, ?, ?, curdate());";
    
            // establish a connection
    
            try (
                Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    
                    // create a car statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(updateTransaction)) {
                        preparedStatement.setInt(1, vehicleID);
                        preparedStatement.setInt(2, customerID);
                        preparedStatement.setInt(3, employeeID);
                        preparedStatement.setInt(4, locationID);
    
                // execute query or update query
    
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
    
                // print SQLException info
                printSQLException(e);
            }
        }


        public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeID, int locationID, 
            String date) {
             
            final String updateTransaction = "update transactions set vehicleID = ?, customerID = ? , employeeID = ?, locationID = ?, datestamp = ? where transactionID = ?;";
    
            // establish a connection
    
            try (
                Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    
                    // create a car statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(updateTransaction)) {
                        preparedStatement.setInt(1, vehicleID);
                        preparedStatement.setInt(2, customerID);
                        preparedStatement.setInt(3, employeeID);
                        preparedStatement.setInt(4, locationID);
                        preparedStatement.setString(5, date);
                        preparedStatement.setInt(6, transactionID);
    
                // execute query or update query
    
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
    
                // print SQLException info
                printSQLException(e);
            }
        }


        public void deleteTransaction(Integer transactionID){
            final String getTransaction = "DELETE FROM transactions where transactionID = ?;";

            try (
                    Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

                    // create a statement using connection object
                        PreparedStatement preparedStatement = connection.prepareStatement(getTransaction);
                        
                ) {
                    preparedStatement.setInt(1, transactionID);
                // execute the car query
                int result = preparedStatement.executeUpdate();
                System.out.println("Number of customer records affected :: " + result);
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
