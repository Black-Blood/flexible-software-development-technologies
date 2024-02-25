package Cars;

public class Motorcycle extends Automobile {

    private int cylinderCapacity;
    private int numberOfWheels;

    public Motorcycle(String brand, String model, int year, int cylinderCapacity, int numberOfWheels) {
        super(brand, model, year);
        this.cylinderCapacity = cylinderCapacity;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void startEngine() {
        System.out.println("Вмикаю двигун мотоцикла " + this);
    }

    @Override
    public void move() {
        System.out.println("Мотоцикл " + this + " їде");
    }

    @Override
    public void stopEngine() {
        System.out.println("Вимикаю двигун мотоцикла " + this);
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String toString() {
        return super.toString() + "\nробочий об'єм циліндра: " + getCylinderCapacity() + "\nКількість коліс: " + getNumberOfWheels() + "\n";
    }
}