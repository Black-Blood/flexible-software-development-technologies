import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        runLaboratoryWork4();
        runLaboratoryWork5();
    }

    private static void runLaboratoryWork4() {
        //region "Код завдання 1 + ускладнене завдання"
        List<Toy> toys = List.of(Toy.createToy());

        // Розрахунок ширини колонок
        List<Integer> columnSizes = Toy
                .columns
                .stream()
                .map((c) -> toys
                        .stream()
                        .map((t) -> t.get(c).length())
                        .reduce(c.length(), Math::max) + 6 // додаємо до найбільшого значення по +3 з кожної сторони
                )
                .toList();


        // Форматування рядку таблиця
        String row = "|" + String.join("|", columnSizes.stream().map((c) -> "   %-" + (c - 3) + "s").toList()) + "|\n";

        // Рамки таблиці
        String rowSplitter = "+" + String.join("+", columnSizes.stream().map("-"::repeat).toList()) + "+";

        // Заголовок таблиці
        System.out.println(rowSplitter);
        System.out.printf(row, Toy.columns.toArray());
        System.out.println(rowSplitter);

        // Дані таблиці
        for (Toy toy : toys) {
            System.out.printf(row, Toy.columns.stream().map(toy::get).toArray());
            System.out.println(rowSplitter);
        }
        //endregion


    }

    private static void runLaboratoryWork5() {
        Scanner scanner = new Scanner(System.in);

        // Введення користувачем початкового числа
        System.out.print("Введіть початкове число (0,100]: ");
        Integer startNumber = null;

        do {
            try {
                startNumber = Integer.valueOf(scanner.nextLine());

                if(startNumber <= 0){
                    startNumber = null;
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.print("Введено некоректне значення. Спробуйте ще раз:\t");
            }
        } while (startNumber == null);

        // Перевірка на парність
        if (startNumber % 2 == 1) {
            startNumber++; // Збільшуємо на 1, якщо непарне
        }

        // Цикл для виведення перших 100 квадратів парних чисел
        for (int i = startNumber; i <= startNumber + 100; i += 2) {
            System.out.println(i + " ^ 2 = " + (i * i));
        }
    }
}