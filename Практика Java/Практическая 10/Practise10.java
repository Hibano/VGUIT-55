import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Practise10 {
    public static void main(String[] args) {
        // Задача 1 Создаем список имен студентов через ArrayList
        List<String> students = Arrays.asList("Иван", "Мария", "Петр", "Анна");
        String fileName = "students.txt";

        try {
            // Задача 2 Записываем список в файл (каждое имя с новой строки)
            FileWriter writer = new FileWriter(fileName);
            for (String student : students) {
                writer.write(student + "\n");
            }
            writer.close();
            System.out.println("Список успешно записан в файл.");

            // Задача 3 Читаем файл и выводим все имена на экран
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("\nИмена студентов из файла:");
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Задача 4 Корректная обработка IOException
            System.out.println("Произошла ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
