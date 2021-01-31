package dk.workkit.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/workkit";
                connection = DriverManager.getConnection(url, "workkituser", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
