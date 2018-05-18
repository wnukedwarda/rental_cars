package pl.wnukedwarda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DriverManagerCP implements ConnectionProvider {
    INSTANCE;

    private static final String USER_NAME = "root";
    private static final String PASS = "3093523borsuk";
    private static final String URL = "jdbc:mysql://localhost:3306/wypozyczalnia";


    public Connection getConnection() throws SQLException {
        return java.sql.DriverManager.getConnection(URL, USER_NAME, PASS);
    }
}
