package pl.wnukedwarda.carService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wnukedwarda.car.Car;
import pl.wnukedwarda.db.ConnectionProvider;
import pl.wnukedwarda.db.DriverManagerCP;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarFinderTest {
    private Car car;
    private CarFinder carFinder;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Car> cars;
    private boolean result;


    @BeforeEach
    void setUp() {
        carFinder = new CarFinder(DriverManagerCP.INSTANCE);
        cars = new ArrayList<>();
    }

    @Test
    void testFindById() throws SQLException {
        int id = 1;
        carFinder.doWtihConnection(connection -> {
            ps = connection.prepareStatement("SELECT * FROM cars WHERE car_id =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                car = carFinder.buildCar(rs);
            }
            connection.close();
        });
        assertEquals(1, car.getCarId());
        assertEquals("Audi", car.getMake());
        assertEquals("A4", car.getModel());
    }

    @Test
    void testFindByMake() throws SQLException {
        String make = "Skoda";
        result = true;
        carFinder.doWtihConnection(connection -> {
            ps = connection.prepareStatement("SELECT * FROM cars WHERE make = ?");
            ps.setString(1, make);
            rs = ps.executeQuery();
            while (rs.next()) {
                car = carFinder.buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });

        for (Car car : cars) {
            result = result && isTrue(make, car.getMake());
        }
        assertTrue(result);
    }

    @Test
    void testFindByModel()throws SQLException {
        String model = "superB";
        result = true;
        carFinder.doWtihConnection(connection -> {
            ps = connection.prepareStatement("SELECT * FROM cars WHERE model = ?");
            ps.setString(1,model);
            rs = ps.executeQuery();
            while(rs.next()){
                car = carFinder.buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });

        for (Car car : cars) {
            result = result && isTrue(model,car.getModel());
        }
        assertTrue(result);
    }

    private boolean isTrue(String string1, String string2) {
        return string1.equals(string2);
    }
}