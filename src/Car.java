public class Car {

    private int model, fuelLevel, fuelConsumption;
    String name, color;
    String brand;


    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(int model, int fuelLevel, int fuelConsumption, String name, String color, String brand) {
        this.model = model;
        this.fuelLevel = fuelLevel;
        this.fuelConsumption = fuelConsumption;
        this.name = name;
        this.color = color;
        this.brand = brand;


    }

    void printDescription() {
        System.out.printf("Ich bin ein %ser %s, Model %d von der Marke %s.\nIch verbrauche %d Liter Benzin pro Kilometer und habe noch %d Liter im Tank!\n\n", color, name, model, brand, fuelConsumption, fuelLevel);
    }

    int getMaxKilometers() {
        return fuelLevel / fuelConsumption;        // fuelConsumption = consumption of liters per km
    }

    boolean isReachable(int km) {
        return getMaxKilometers() >= km;
    }

    void drive(int km) {
        // sets the fuel level of the object to an updated amount after "driving" for a certain amount of kms
        if (isReachable(km)) fuelLevel -= fuelConsumption * km;
    }
}