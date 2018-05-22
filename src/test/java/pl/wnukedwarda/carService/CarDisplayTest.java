package pl.wnukedwarda.carService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wnukedwarda.car.Car;
import pl.wnukedwarda.car.CarDisplay;
import pl.wnukedwarda.db.DriverManagerCP;

import java.sql.SQLException;

class CarDisplayTest {

    private Car car;
    private CarDisplay carDisplay;

    @BeforeEach
    void setUp(){
    carDisplay = new CarDisplay(DriverManagerCP.INSTANCE);
    }

    @Test
    void testViewAll()throws SQLException {
        carDisplay.viewAll();
    }
}