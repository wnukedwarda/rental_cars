package pl.wnukedwarda.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DriverManagerCPTest {

    private static final String USER_NAME = "root";
    private static final String PASS = "3093523borsuk";
    private static final String URL = "jdbc:mysql://localhost:3306/wypozyczalnia";
    private Connection connection;


    @Test
    void testGetConnection() throws SQLException {
        boolean result;
        try{
            connection = DriverManager.getConnection(URL,USER_NAME,PASS);
            result = true;
        }catch (SQLException e){
            e.printStackTrace();
            result = false;
        }
        assertTrue(result);
    }
}