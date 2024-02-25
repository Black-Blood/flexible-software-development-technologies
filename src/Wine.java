import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record Wine (
        String name,
        String brand,
        String country,
        LocalDate bottlingDate,
        String note
) {
    public String getValueByColumnName(String column) {
        return switch (column) {
            case "Назва" -> name;
            case "Виробник" -> brand;
            case "Країна" -> country;
            case "Дата виробництва" -> bottlingDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            case "Витримка" -> calculateAge(LocalDate.now()).toString();
            case "Примітка" -> note;
            default -> "";
        };
    }


    public static List<String> columns = List.of(
            "Назва",
            "Виробник",
            "Країна",
            "Дата виробництва",
            "Витримка",
            "Примітка"
    );

    public Integer calculateAge(LocalDate toDate) {
        return Period.between(bottlingDate, toDate).getYears();
    }

    //region Getters

    @Override
    public String name() {
        return name;
    }

    @Override
    public String brand() {
        return brand;
    }

    @Override
    public String country() {
        return country;
    }

    @Override
    public LocalDate bottlingDate() {
        return bottlingDate;
    }

    @Override
    public String note() {
        return note;
    }
    //endregion
}