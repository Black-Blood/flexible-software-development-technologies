import Cars.*;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        part1();
        part2();
        part3();
    }

    //region Завдання "Частина 1"
    public static void part1() {
        //region "б) Створіть другий клас, наприклад, Main, в якому створіть три екземпляри класу Class"
        Toy toy1 = new Toy("М'ячик", 100, "Acme");
        Toy toy2 = new Toy("Лялька", 200, "Barbie");
        Toy toy3 = new Toy();
        //endregion

        //region "в) Виведіть на консоль значення їх полів"
        System.out.println("Іграшка 1:");
        printToyInfo(toy1);

        System.out.println("Іграшка 2:");
        printToyInfo(toy2);

        System.out.println("Іграшка 3:");
        printToyInfo(toy3);
        //endregion

        updateToy(toy2, 300);
        updateToy(toy3, "New Manufacturer");
    }

    //region "г) Додати в клас Main два методи, які мають бути з параметрами. Викликати один метод з іншого"
    protected static void printToyInfo(Toy toy) {
        System.out.println("Назва: " + toy.getName());
        System.out.println("Ціна: " + toy.getPrice());
        System.out.println("Виробник: " + toy.getManufacturer());
        System.out.println("===================================");
    }
    protected static void updateToy(Toy toy, int newPrice) {
        toy.setPrice(newPrice);
        printToyInfo(toy);
    }
    //endregion

    //region "д) Додайте перевантажений метод. Викликати цей метод"
    protected static void updateToy(Toy toy, String newManufacturer) {
        toy.setManufacturer(newManufacturer);
        printToyInfo(toy);
    }
    //endregion
    //endregion

    //region Завдання "Частина 2"
    protected static void part2() {
        Wine wine1 = new Wine(
                "Merlot",
                "Chateau Margaux",
                "France",
                LocalDate.of(2018, Month.AUGUST, 1),
                "Вишукане та елегантне вино з ароматом чорної смородини, тютюну та кедра."
        );

        // Розрахунок ширини колонок
        Integer cellNameSize = Wine.columns.stream().map(String::length).reduce(0, Math::max);
        Integer cellValueSize = Wine.columns.stream().map(wine1::getValueByColumnName).map(String::length).reduce(0, Math::max);

        // Форматування рядку таблиця
        String row = "|  %-" + cellNameSize + "s  |  %-" + cellValueSize + "s  |\n";
        String rowSplitter = "+" + "-".repeat(cellNameSize + 4) + "+" + "-".repeat(cellValueSize + 4) + "+";

        System.out.println(rowSplitter);
        for (String column : Wine.columns){
            System.out.printf(row, column, wine1.getValueByColumnName(column));
            System.out.println(rowSplitter);
        }

        System.out.println("Через 5 років витримка становитиме: " + wine1.calculateAge(LocalDate.now().plusYears(5)) + " років");
    }
    //endregion

    //region Завдання "Ускладнене"
    protected static void part3(){
        Automobile[] vehicles = {
                new Car("Toyota", "Camry", 2023, 5, "Gasoline"),
                new Truck("Ford", "F-150", 2022, 3500, "Open bed"),
                new Motorcycle("Harley-Davidson", "Street Glide", 2021, 1745, 2),
                new Car("Honda", "Civic", 2020, 5, "Hybrid"),
                new Truck("Chevrolet", "Silverado", 2019, 5000, "Enclosed trailer"),
        };

        Driver driver = new Driver();

        for (Automobile vehicle : vehicles) {
            driver.work(vehicle);
            driver.talk(vehicle);
            System.out.println("============================");
        }
    }
    //endregion
}