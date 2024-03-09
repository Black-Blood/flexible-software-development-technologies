import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class ToyDirectory {

    public static void create(Path basePath) {
        try {
            Files.createDirectories(basePath.resolve("D - Іграшки\\1 - Плюшеві\\1.1 - Ляльки"));
            Files.createDirectories(basePath.resolve("D - Іграшки\\1 - Плюшеві\\1.2 - Тварини"));
            Files.createDirectories(basePath.resolve("D - Іграшки\\1 - Плюшеві\\1.3 - Рослини"));
            Files.createDirectories(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.1 - Машини\\2.1.1 - Спортивні\\2.1.1.1 - Зелені"));
            Files.createDirectories(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.1 - Машини\\2.1.2 - Вантажівки\\2.1.2.1 - Червоні"));
            Files.createDirectories(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.2 - Трансформери\\2.2.1 - Автоботи"));
            Files.createDirectories(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.2 - Трансформери\\2.2.2 - Десептикони"));
        } catch (IOException e) {
            System.err.println("Помилка при створенні каталогу: " + e.getMessage());
        }
    }

    public static void navigate(Path basePath) {

        // а)
        Path currentDir = basePath.resolve("D - Іграшки");
        System.out.println("Зараз: " + currentDir.getFileName());
        System.out.println("===============================\n");

        // б)
        currentDir = currentDir.resolve("1 - Плюшеві\\1.2 - Тварини");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.1 - Машини\\2.1.2 - Вантажівки");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.2 - Трансформери");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("1 - Плюшеві");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.2 - Трансформери\\2.2.2 - Десептикони");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().getParent().resolve("2 - Пластикові\\2.1 - Машини\\2.1.2 - Вантажівки\\2.1.2.1 - Червоні");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2.1.1 - Спортивні\\2.1.1.1 - Зелені");
        System.out.println("Зараз: " + currentDir.getFileName());

        createTextFile(currentDir, "Блискавка.txt");
        createTextFile(currentDir, "Еко-гонщик.txt");
        createTextFile(currentDir, "Смарагдовий-вітер.txt");
        System.out.println("===============================\n");

        // в)
        currentDir = currentDir.getParent().getParent().resolve("2.1.2 - Вантажівки");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent();
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().resolve("1 - Плюшеві\\1.1 - Ляльки");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().resolve("1.3 - Рослини");
        System.out.println("Зараз: " + currentDir.getFileName());

        createTextFile(currentDir, "Пальма.txt");
        createTextFile(currentDir, "Дуб.txt");
        System.out.println("===============================\n");

        // г)
        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.1 - Машини");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent();
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.resolve("1 - Плюшеві\\1.1 - Ляльки");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.1 - Машини\\2.1.1 - Спортивні");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2.2 - Трансформери\\2.2.2 - Десептикони");
        System.out.println("Зараз: " + currentDir.getFileName());

        createTextFile(currentDir, "Меґатрон.txt");
        createTextFile(currentDir, "Скреппер.txt");
        System.out.println("===============================\n");

        // д)
        currentDir = currentDir.getParent().getParent().getParent();
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.resolve("1 - Плюшеві\\1.2 - Тварини");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.1 - Машини");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().resolve("2.2 - Трансформери\\2.2.1 - Автоботи");
        System.out.println("Зараз: " + currentDir.getFileName());

        createTextFile(currentDir, "Грімлок.txt");
        createTextFile(currentDir, "Сільверболт.txt");
        System.out.println("===============================\n");

        // е)
        currentDir = currentDir.getParent().getParent().getParent().resolve("1 - Плюшеві\\1.3 - Рослини");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().resolve("2 - Пластикові\\2.1 - Машини\\2.1.1 - Спортивні\\2.1.1.1 - Зелені");
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().getParent().getParent();
        System.out.println("Зараз: " + currentDir.getFileName());

        currentDir = currentDir.getParent().resolve("1 - Плюшеві");
        System.out.println("Зараз: " + currentDir.getFileName());

        createTextFile(currentDir, "Плєшеві Іграшки1.txt");
        createTextFile(currentDir, "Плєшеві Іграшки2.txt");
        createTextFile(currentDir, "Плєшеві Іграшки3.txt");
        createTextFile(currentDir, "Плєшеві Іграшки4.txt");

        // Є
        try {
            Files.delete(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.1 - Машини\\2.1.1 - Спортивні\\2.1.1.1 - Зелені\\Блискавка.txt"));
            System.out.println("Видалено файл: Блискавка.txt");

            Files.delete(basePath.resolve("D - Іграшки\\1 - Плюшеві\\1.3 - Рослини\\Пальма.txt"));
            System.out.println("Видалено файл: Пальма.txt");

            Files.delete(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.2 - Трансформери\\2.2.2 - Десептикони\\Меґатрон.txt"));
            System.out.println("Видалено файл: Меґатрон.txt");

            Files.delete(basePath.resolve("D - Іграшки\\2 - Пластикові\\2.2 - Трансформери\\2.2.1 - Автоботи\\Сільверболт.txt"));
            System.out.println("Видалено файл: Сільверболт.txt");

            Files.delete(basePath.resolve("D - Іграшки\\1 - Плюшеві\\Плєшеві Іграшки2.txt"));
            System.out.println("Видалено файл: Плєшеві Іграшки2.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTextFile(Path dir, String fileName) {
        try {
            Files.createDirectories(dir); // Створення всіх каталогів, які не існують
            Path filePath = dir.resolve(fileName);
            Files.createFile(filePath);
            System.out.println("Створено файл: " + filePath.toString());
        } catch (IOException e) {
            System.err.println("Помилка при створенні файлу: " + e.getMessage());
        }
    }

}