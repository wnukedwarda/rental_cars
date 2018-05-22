package pl.wnukedwarda.car;

import java.sql.Date;

public class Car {

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

    public Car(int carId, String make, String model, int yearbook, String bodyType,
               double engineSize, String fuel, double horsePower, Date serviceDate,
               boolean carStatus, int clientId) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.yearbook = yearbook;
        this.bodyType = bodyType;
        this.engineSize = engineSize;
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.serviceDate = serviceDate;
        this.carStatus = carStatus;
        this.clientId = clientId;
    }

    public int getCarId() { return carId; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public int getYearbook() { return yearbook; }

    public String getBodyType() { return bodyType; }

    public double getEngineSize() { return engineSize; }

    public String getFuel() { return fuel; }

    public double getHorsePower() { return horsePower; }

    public Date getServiceDate() { return serviceDate; }

    public boolean isCarStatus() { return carStatus; }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearbook=" + yearbook +
                ", bodyType='" + bodyType + '\'' +
                ", engineSize=" + engineSize +
                ", fuel='" + fuel + '\'' +
                ", horsePower=" + horsePower +
                ", serviceDate=" + serviceDate +
                ", carStatus=" + carStatus +
                '}';
    }

    public int getClientId() {
        return clientId;
    }
}
