import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConn {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "1676542";
    private static final Connection CONNECTION =  createConn();

    public static Connection getConn() {
        return CONNECTION;
    }

    private static Connection createConn() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);


        } catch (Exception ex) {
            System.out.println("You have exception in the program =(");
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        return null;
    }


}
