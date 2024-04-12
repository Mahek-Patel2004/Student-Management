import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.io.*;

public class conn {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/abc";
        String user = "root";
        String password = "@Mayra#1918.Sis";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // If the connection is successful, print a success message
            System.out.println("Connection to the database established successfully.");
        } catch (SQLException e) {
            // Handle SQL-related exceptions
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Handle driver loading exception
            e.printStackTrace();
            System.err.println("Error loading JDBC driver: " + e.getMessage());
        } finally {
            System.out.println("Final");
        }
    }
}
