package friday.qa.data;

public class CarDetails {

    private String brand;
    private String model;
    private String bodyType;
    private String enginePower;
    private String carEngine;
    private String fuel;

    public CarDetails(String brand, String model, String bodyType, String enginePower, String carEngine, String fuel) {
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.enginePower = enginePower;
        this.carEngine = carEngine;
        this.fuel = fuel;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public String getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", enginePower='" + enginePower + '\'' +
                ", carEngine='" + carEngine + '\'' +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
