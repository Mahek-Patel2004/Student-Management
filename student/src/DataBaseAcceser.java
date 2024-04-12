import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseAcceser {
    private static Statement statement;
    private static Connection connection;

    public static synchronized Statement getDatabaseStatement() {
        if (statement == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root",
                        "@Mayra#1918.Sis");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return statement;
    }

}
