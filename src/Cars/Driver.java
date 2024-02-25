package Cars;

public class Driver {

    public void work(Automobile automobile) {
        automobile.startEngine();
        automobile.move();
        automobile.stopEngine();
    }

    public void talk(Automobile automobile) {
        System.out.printf(automobile.toString());
    }
}