import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnection {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/abc";
        String user = "root";
        String password = "@Mayra#1918.Sis";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                // If the connection is successful, print a success message
                System.out.println("Connection to the database established successfully.");
            } catch (Exception e) {
                // Handle driver loading exception
                System.err.println("Error loading JDBC driver: " + e.getMessage());
            }

        }

        catch (Exception e) {
            // Handle database connection exception
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}