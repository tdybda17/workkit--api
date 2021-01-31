package dk.workkit.database.databases;

import dk.workkit.database.migrations.Migrate;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {

    @Test
    void hejsa() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sqlite3-test.db");
            new Migrate().migrate(connection);
            System.out.println("Yay");
        } catch (SQLException e) {
            System.out.println("Nå...");
        }
    }
}