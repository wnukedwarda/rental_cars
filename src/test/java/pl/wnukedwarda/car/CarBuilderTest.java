package pl.wnukedwarda.car;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CarBuilderTest {

    Date date = new Date(2018,02,11);

    @Test
    void testCarBuilder() {
        Car car = new CarBuilder()
                .setCarId(1)
                .setMake("Audi")
                .setModel("A4")
                .setYearbook(2018)
                .setBodyType("sedan")
                .setEngineSize(3.0)
                .setFuel("diesel")
                .setHorsePower(240.0)
                .setServiceDate(date)
                .setCarStatus(true)
                .build();

        assertEquals(1,car.getCarId());
        assertEquals("Audi",car.getMake());
        assertEquals(240.0, car.getHorsePower());
        assertEquals(true, car.isCarStatus());
    }
}