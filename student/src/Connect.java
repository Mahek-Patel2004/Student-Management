import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    Connection c;
    Statement statement;

    public Connect() {
        try {
            System.out.println("working");
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root",
                    "@Mayra#1918.Sis");
            // c = DriverManager.getConnection(
            // "jdbc:mysql://10.90.0.202:3306/abc?user=root&password=@Mayra#1918.Sis");

            statement = c.createStatement();
            String str = "select * from details";
            ResultSet res = statement.executeQuery(str);
            System.err.println(res.toString());

            // statement
            // .execute("insert into details values(12, 'aaa' , 'aa' , '21312' , 'assa' ,
            // '21312312' , 'm')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement createStatement() throws SQLException {
        return c.createStatement();
    }

    public static void main(String[] args) {
        new Connect();
    }
}
