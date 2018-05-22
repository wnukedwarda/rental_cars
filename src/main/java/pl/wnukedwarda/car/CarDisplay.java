package pl.wnukedwarda.car;

import pl.wnukedwarda.db.ConnectionProvider;
import pl.wnukedwarda.db.DriverManagerCP;
import pl.wnukedwarda.db.JdbcService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDisplay extends JdbcService {

    public CarDisplay(ConnectionProvider connectionProvider) {
        super(connectionProvider);
    }

    public void viewAll() {
        doWtihConnection(connection -> {
            ResultSet rs = connection.createStatement()
                    .executeQuery("SELECT * FROM cars ORDER BY car_id");

            while(rs.next()){
                printCar(rs);
            }
        });
    }

    public void printCar(ResultSet rs) throws SQLException {
        System.out.println( "Car ID: " + rs.getInt(
                1) +
                " Make: " + rs.getString(2) +
                " Model: " + rs.getString(3) +
                " Yearbook: " + rs.getInt(4) +
                " Body Type: " + rs.getString(5) +
                " Engine Size: " + rs.getDouble(6) +
                " Fuel: " + rs.getString(7) +
                " Horse Power: " + rs.getDouble(8) +
                " Service Date: " + rs.getDate(9) +
                " Car Status " + rs.getBoolean(10) +
                " Client ID: " + rs.getInt(11));
    }
}

