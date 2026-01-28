package Java15;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Zadanie15 {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        writeStudentData();
        readAndAnalyzeData();
    }

    private static void writeStudentData() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("Иванов 85\n");
            writer.write("Петров 92\n");
            writer.write("Сидоров 78\n");
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
        }
    }

    private static void readAndAnalyzeData() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            System.out.println("\nСодержимое файла:");
            int maxScore = Integer.MIN_VALUE;
            String bestStudent = "Не найден";

            for (String line : lines) {
                System.out.println(line);
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    try {
                        int score = Integer.parseInt(parts[1]);
                        if (score > maxScore) {
                            maxScore = score;
                            bestStudent = parts[0];
                        }
                    } catch (NumberFormatException ignored) {
                        System.err.println("Некорректный формат балла в строке: " + line);
                    }
                }
            }
            System.out.println("\nЛучший студент: " + bestStudent + " (" + maxScore + " баллов)");
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
    }
}