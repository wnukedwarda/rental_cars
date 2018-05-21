package pl.wnukedwarda.car;

import java.sql.Date;

public class CarBuilder {

    private int carId;
    private String make;
    private String model;
    private int yearbook;
    private String bodyType;
    private double engineSize;
    private String fuel;
    private double horsePower;
    private Date serviceDate;
    private boolean carStatus;
    private int clientId;

    public CarBuilder setCarId(int carId) {
        this.carId = carId;
        return this;
    }

    public CarBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setYearbook(int yearbook) {
        this.yearbook = yearbook;
        return this;
    }

    public CarBuilder setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public CarBuilder setEngineSize(double engineSize) {
        this.engineSize = engineSize;
        return this;
    }

    public CarBuilder setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public CarBuilder setHorsePower(double horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public CarBuilder setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
        return this;
    }

    public CarBuilder setCarStatus(boolean carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    public CarBuilder setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public Car build() {
        return new Car(carId, make, model, yearbook, bodyType, engineSize,
                fuel, horsePower, serviceDate, carStatus, clientId);
    }

}
