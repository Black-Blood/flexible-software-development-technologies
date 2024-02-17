import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
}
