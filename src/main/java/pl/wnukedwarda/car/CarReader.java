package pl.wnukedwarda.car;

import pl.wnukedwarda.db.ConnectionProvider;
import pl.wnukedwarda.db.JdbcService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CarReader extends JdbcService {

    private Scanner scanner;
    private CarBuilder carBuilder;
    private Car car;
    private boolean tryAgain;

    public CarReader(ConnectionProvider connectionProvider, Scanner scanner) {
        super(connectionProvider);
        this.scanner = scanner;
    }

    public void addNewCar() {
        do {
            try {
                System.out.println("Enter Car info:");
                System.out.println("Make:");
                String make = scanner.nextLine();
                System.out.println("Model:");
                String model = scanner.nextLine();
                System.out.println("Yearbook:");
                int yearbook = Integer.parseInt(scanner.nextLine());
                System.out.println("Body Type:");
                String bodyType = scanner.nextLine();
                System.out.println("Engine Size");
                double engineSize = Double.parseDouble(scanner.nextLine());
                System.out.println("Fuel");
                String fuel = scanner.nextLine();
                System.out.println("Horse Power");
                double horsePower = Double.parseDouble(scanner.nextLine());
                System.out.println("Service Date");
                System.out.println("Year");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.println("Month");
                int month = Integer.parseInt(scanner.nextLine());
                System.out.println("Day");
                int day = Integer.parseInt(scanner.nextLine());
                Date date = new Date(year, month, day);
                System.out.println("Car Available");
                boolean available = "true".equals(scanner.nextLine());
                System.out.println("Client ID");
                int clientId = Integer.parseInt(scanner.nextLine());
                Car car = new CarBuilder()
                        .setCarId(lastCar().getCarId())
                        .setMake(make)
                        .setModel(model)
                        .setYearbook(yearbook)
                        .setBodyType(bodyType)
                        .setEngineSize(engineSize)
                        .setFuel(fuel)
                        .setHorsePower(horsePower)
                        .setServiceDate(date)
                        .setCarStatus(available)
                        .setClientId(clientId)
                        .build();

                saveNewCar(car);
                tryAgain = false;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                tryAgain = true;
            }
        } while (tryAgain);

    }

    private void saveNewCar(Car car) {
        doWtihConnection(connection -> {
            String insert = "INSERT INTO cars(car_id, make, model, yearbook, body_type, engine_size," +
                    "fuel, horse_power, service_date, car_status, client_id)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, car.getCarId() + 1);
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYearbook());
            ps.setString(5, car.getBodyType());
            ps.setDouble(6, car.getEngineSize());
            ps.setString(7, car.getFuel());
            ps.setDouble(8, car.getHorsePower());
            ps.setDate(9, car.getServiceDate());
            ps.setBoolean(10, car.isCarStatus());
            ps.setInt(11, car.getClientId());
            ps.executeUpdate();
            connection.close();
        });
    }

    public void delete(int id) {
        doWtihConnection(connection -> {
            String delete = "DELETE FROM cars WHERE car_id = ?";
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, id);
            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("Error");
            } else System.out.println("Success");
            connection.close();
        });
    }

    private Car lastCar() throws SQLException {
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars");
            ResultSet rs = ps.executeQuery();

            if (rs.last()) {
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
            }
        });
        return car;
    }
}
