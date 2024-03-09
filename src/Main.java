import java.util.*;

public class Main {
    public static void main(String[] args) {
        part1Array();
        part1Collections();
        part2();
        part3();
    }

    private static void part1Array() {
        Scanner scanner = new Scanner(System.in);

        // Введення довжини масиву
        System.out.print("Введіть довжину масиву: ");
        int length = scanner.nextInt();

        // Введення значень масиву
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Введіть %d-й елемент: ", i + 1);
            array[i] = scanner.nextInt();
        }

        // Пошук та підрахунок повторень
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int number : array) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        // Вивід результатів
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("Число %d повторюється %d разів\n", entry.getKey(), entry.getValue());
            }
        }
    }

    private static void part1Collections() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть довжину колекції: ");
        int length = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        // Введення значень масиву
        for (int i = 0; i < length; i++) {
            System.out.printf("Введіть %d-й елемент: ", i + 1);
            list.add(scanner.nextInt());
        }

        // Пошук та підрахунок повторень
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int number : list) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        // Вивід результатів
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("Число %d повторюється %d разів\n", entry.getKey(), entry.getValue());
            }
        }
    }

    private static void part2() {
        Scanner scanner = new Scanner(System.in);

        // Введення довжини масиву
        System.out.print("Введіть довжину масиву: ");
        int length = scanner.nextInt();

        // Перевірка коректності довжини
        while (length <= 0) {
            System.err.println("Довжина масиву має бути більшою за 0!");
            System.out.print("Введіть довжину масиву: ");
            length = scanner.nextInt();
        }

        // Введення значень масиву
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Введіть %d-й елемент масиву: ", i + 1);
            array[i] = scanner.nextInt();
        }

        // Введення значення зміщення
        System.out.print("Введіть значення зміщення: ");
        int shift = scanner.nextInt();

        // Зміщення значень масиву
        for (int i = 0; i < shift; i++) {
            int tempItem = array[length - 1];
            for(int j = 0; j < length - 1; j++){
                array[length - 1 - j] = array[length - 2 - j];
            }
            array[0] = tempItem;
            System.out.println(Arrays.toString(array));
        }
    }

    private static void part3() {
        Scanner scanner = new Scanner(System.in);

        // Введення розмірності масиву
        System.out.print("Введіть кількість рядків масиву: \t");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпчиків масиву: \t");
        int columns = scanner.nextInt();

        // Створення масиву
        int[][] array = new int[rows][columns];

        // Введення елементів масиву
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        // Виведення початкового масиву
        System.out.println("Початковий масив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // Введення значення зміщення
        System.out.println("На скільки значень змістити його елементи?");
        int shift = scanner.nextInt();

        for (int i = 0; i < shift; i++) {
            int next = array[rows - 1][columns -1];
            int temp;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    temp = array[r][c];
                    array[r][c] = next;
                    next = temp;
                }
            }

            for(int[] row : array){
                System.out.println(Arrays.toString(row));
            }

            System.out.println("============");
        }


    }
}