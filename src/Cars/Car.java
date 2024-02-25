package Cars;

public class Car extends Automobile {

    private int numberOfSeats;
    private String engineType;

    public Car(String brand, String model, int year, int numberOfSeats, String engineType) {
        super(brand, model, year);
        this.numberOfSeats = numberOfSeats;
        this.engineType = engineType;
    }

    @Override
    public void startEngine() {
        System.out.println("Вмикаю двигун " + engineType + " автомобіля ");
    }

    @Override
    public void move() {
        System.out.println("Автомобіль їде");
    }

    @Override
    public void stopEngine() {
        System.out.println("Вимикаю двигун " + engineType + " автомобіля ");
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nТип двигуна: " + getEngineType() + "\nКількість місць: " + getNumberOfSeats() + "\n";
    }
}