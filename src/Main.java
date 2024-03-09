import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        runLaboratoryWork1();
        runLaboratoryWork4();
    }

    private static void runLaboratoryWork4(){
        List<String> Header = List.of("A", "B", "C", "A && B && C", "A && B || C", "A || B && C", "A || B || C");

        List<Boolean> A = List.of(false, false, false, true, true, true, false, true);
        List<Boolean> B = List.of(false, false, true, false, true, false, true, true);
        List<Boolean> C = List.of(false, true, false, false, false, true, true, true);

        List<Boolean> A_and_B_and_C = IntStream.range(0, A.size()).mapToObj((i) -> (A.get(i) && B.get(i) && C.get(i))).toList();
        List<Boolean> A_and_B_or_C = IntStream.range(0, A.size()).mapToObj((i) -> (A.get(i) && B.get(i) || C.get(i))).toList();
        List<Boolean> A_or_B_and_C = IntStream.range(0, A.size()).mapToObj((i) -> (A.get(i) || B.get(i) && C.get(i))).toList();
        List<Boolean> A_or_B_or_C = IntStream.range(0, A.size()).mapToObj((i) -> (A.get(i) || B.get(i) || C.get(i))).toList();


        // Розрахунок ширини колонок
        List<Integer> columnSizes = Header
                .stream()
                .map((c) -> 17)
                .toList();


        // Форматування рядку таблиця
        String row = "|" + String.join("|", columnSizes.stream().map((c) -> "   %-" + (c - 3) + "s").toList()) + "|\n";

        // Рамки таблиці
        String rowSplitter = "+" + String.join("+", columnSizes.stream().map("-"::repeat).toList()) + "+";

        // Заголовок таблиці
        System.out.println(rowSplitter);
        System.out.printf(row, Header.toArray());
        System.out.println(rowSplitter);

        // Дані таблиці
        for(int i = 0; i < Header.size(); i++) {
            System.out.printf(row,
                    A.get(i),
                    B.get(i),
                    C.get(i),
                    A_and_B_and_C.get(i),
                    A_and_B_or_C.get(i),
                    A_or_B_and_C.get(i),
                    A_or_B_or_C.get(i)
            );
            System.out.println(rowSplitter);
        }
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


    }
}