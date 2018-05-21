package pl.wnukedwarda.carService;

import pl.wnukedwarda.car.Car;
import pl.wnukedwarda.car.CarBuilder;
import pl.wnukedwarda.db.ConnectionProvider;
import pl.wnukedwarda.db.JdbcService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarFinder extends JdbcService {

    CarBuilder carBuilder = new CarBuilder();
    Car car = null;

    public CarFinder(ConnectionProvider connectionProvider) {
        super(connectionProvider);
    }

    public Car findById(int id) {
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM cars WHERE car_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car = buildCar(rs);
            }
            connection.close();
        });
        return car;
    }

    public List<Car> findByMake(String make) {
        List<Car> cars = new ArrayList<>();
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM cars WHERE make =?");
            ps.setString(1, make);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car = buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });
        return cars;
    }

    public List<Car> findByModel(String model) {
        List<Car> cars = new ArrayList<>();
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM cars WHERE model=?");
            ps.setString(1, model);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                car = buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });
        return cars;
    }

    public List<Car> findByYearbook(int yearbook) {
        List<Car> cars = new ArrayList<>();
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM cars WHERE yearbook=?");
            ps.setInt(1, yearbook);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car = buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });
        return cars;
    }

    public List<Car> findyByBodyType(String bodyType) {
        List<Car> cars = new ArrayList<>();
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM cars WHERE body_type=?");
            ps.setString(1, bodyType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car = buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });
        return cars;
    }

    public List<Car> findByCarAvailable() {
        List<Car> cars = new ArrayList<>();
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM cars WHERE car_status = true");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car = buildCar(rs);
                cars.add(car);
            }
            connection.close();
        });
        return cars;
    }

    public Car buildCar(ResultSet rs) throws SQLException {
        car = new CarBuilder()
                .setCarId(rs.getInt(1))
                .setMake(rs.getString(2))
                .setModel(rs.getString(3))
                .setYearbook(rs.getInt(4))
                .setBodyType(rs.getString(5))
                .setEngineSize(rs.getDouble(6))
                .setFuel(rs.getString(7))
                .setHorsePower(rs.getDouble(8))
                .setServiceDate(rs.getDate(9))
                .setCarStatus(rs.getBoolean(10))
                .setClientId(rs.getInt(11))
                .build();

        return car;
    }
}
