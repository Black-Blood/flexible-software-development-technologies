package Cars;

public class Truck extends Automobile {

    private int carryingCapacity;
    private String trailerType;

    public Truck(String brand, String model, int year, int carryingCapacity, String trailerType) {
        super(brand, model, year);
        this.carryingCapacity = carryingCapacity;
        this.trailerType = trailerType;
    }

    @Override
    public void startEngine() {
        System.out.println("Вмикаю двигун вантажівки ");
    }

    @Override
    public void move() {
        System.out.println("Вантажівка їде");
    }

    @Override
    public void stopEngine() {
        System.out.println("Вимикаю двигун вантажівки ");
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public String getTrailerType() {
        return trailerType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nВантажопідємність: " + getCarryingCapacity() + "\nТип: " + getTrailerType() + "\n";
    }
}