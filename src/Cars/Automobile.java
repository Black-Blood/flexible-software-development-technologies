package Cars;

public abstract class Automobile {

    protected String brand;
    protected String model;
    protected int year;

    public Automobile(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public abstract void startEngine();

    public abstract void move();

    public abstract void stopEngine();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }
}