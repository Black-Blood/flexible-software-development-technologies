import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Toy {
    private final String name;
    private final String type;
    private final Byte age;
    private final Double price;
    private final String material;
    private final Integer quantity;
    private final LocalDate deliveryDate;
    private final Boolean canSell;

    public String get(String column) {
        return switch (column) {
            case "Назва" -> this.name;
            case "Тип" -> this.type;
            case "Вік" -> this.age.toString();
            case "Ціна" -> String.format("%.2f", this.price);
            case "Матеріал" -> this.material;
            case "Кількість" -> this.quantity.toString();
            case "Продається" -> this.canSell ? "Tak" : "Ні";
            case "Дата поставки" -> this.deliveryDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            default -> "";
        };
    }

    public Toy(
            String name,
            String type,
            Byte age,
            Double price,
            String material,
            Integer quantity,
            LocalDate deliveryDate,
            Boolean canSell
    ){
        this.name = name;
        this.type = type;
        this.age = age;
        this.price = price;
        this.material = material;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.canSell = canSell;
    }


    public static List<String> columns = List.of(
            "Назва",
            "Тип",
            "Вік",
            "Ціна",
            "Матеріал",
            "Кількість",
            "Продається",
            "Дата поставки"
    );

    public static Toy createToy() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть назву іграшки:\t");
        String name = scanner.nextLine();

        System.out.print("Введіть тип іграшки:\t");
        String type = scanner.nextLine();

        System.out.print("Введіть рекомендований вік (число):\t");
        Byte age = null;
        while (age == null) {
            try {
                age = Byte.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Введено некоректне значення. Вік - це число від 0 до 127. Спробуйте ще раз:\t");
            }
        }

        System.out.print("Введіть ціну (число з двома знаками після коми):\t");
        Double price = null;
        do {
            try {
                price = Double.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Введено некоректне значення. Ціна - це число з двома знаками після коми. Спробуйте ще раз:\t");
            }
        } while (price == null);

        System.out.print("Введіть матеріал іграшки:\t");
        String material = scanner.nextLine();

        System.out.print("Введіть кількість іграшок на складі (ціле число):\t");
        Integer quantity = null;
        while (quantity == null) {
            try {
                quantity = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Введено некоректне значення. Кількість - це ціле число. Спробуйте ще раз:\t");
            }
        }

        System.out.print("Введіть дату поставки (формат dd.MM.yyyy):\t");
        LocalDate deliveryDate = null;
        while (deliveryDate == null) {
            try {
                deliveryDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (Exception e) {
                System.out.print("Введено некоректну дату. Формат дати dd.MM.yyyy. Спробуйте ще раз:\t");
            }
        }

        System.out.print("Чи можна продавати цю іграшку? (Так/Ні)");
        boolean canSell = false;
        while (true) {
            String answer = scanner.nextLine().toLowerCase();

            if(answer.equals("так") || answer.equals("ні")){
                canSell = answer == "так" ? true : false;
                break;
            } else {
                System.out.print("Введіть 'Так' або 'Ні':\t");
            }
        }

        return new Toy(name, type, age, price, material, quantity, deliveryDate, canSell);
    }
}
