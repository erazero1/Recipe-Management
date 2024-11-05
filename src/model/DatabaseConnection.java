package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final Connection connection;
    private static final String USER = "postgres";
    private static final String DB_NAME = "recipes";
    private static final String PASSWORD = "1234";

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + DB_NAME, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
