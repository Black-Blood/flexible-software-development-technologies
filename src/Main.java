import java.util.*;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        runLaboratoryWork1();
        runLaboratoryWork3();
    }

    private static void runLaboratoryWork3(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до кореневого каталогу: ");
        String rootPath = scanner.nextLine();
        ToyDirectory.create(Paths.get(rootPath));
        ToyDirectory.navigate(Paths.get(rootPath));
    }

    private static void runLaboratoryWork1() {
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


        //region "Код завдання 2"
        String line1 = "I like Java !!!";
        String line2 = "Я вивчаю Java!";

        // Роздрукувати останній символ рядка
        System.out.println("Останній символ line1: " + line1.charAt(line1.length() - 1)); // !
        System.out.println("Останній символ line2: " + line2.charAt(line2.length() - 1)); // !

        // перевірити чи закінчується рядок підрядком “!!!”
        System.out.println("line1 закінчується на '!!!': " + line1.endsWith("!!!")); // true
        System.out.println("line2 закінчується на '!!!': " + line2.endsWith("!!!")); // false

        // перевірити чи починається рядок підрядком “I like”
        System.out.println("line1 починається з 'I like': " + line1.startsWith("I like")); // true
        System.out.println("line2 починається з 'I like': " + line2.startsWith("I like")); // false

        // перевірити чи містить рядок підрядок “Java”
        System.out.println("line1 містить 'Java': " + line1.contains("Java")); // true
        System.out.println("line2 містить 'Java': " + line2.contains("Java")); // true

        // замінити всі символи “a” на “o”
        System.out.println("line1 з 'а' на 'о': " + line1.replace('a', 'о')); // I like Jovо !!!
        System.out.println("line2 з 'а' на 'о': " + line2.replace('а', 'о')); // Я вивчою Jovо!

        // вирізати рядок “Java”
        System.out.println("line1 без 'Java': " + line1.substring(0, 7) + line1.substring(12)); // I like !!!
        System.out.println("line2 без 'Java': " + line2.substring(0, 9) + line2.substring(13)); // Я вивчаю !
        //endregion
    }
}