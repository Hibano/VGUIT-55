import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Practise13 {
    public static void main(String[] args) {

        // Задача 1. Создаём список (ArrayList) имён студентов.
        // Добавляем 5 имён, имя "Анна" повторяется дважды.
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Анна");
        studentNames.add("Борис");
        studentNames.add("Виктор");
        studentNames.add("Анна");   // дубликат
        studentNames.add("Галина");

        // Задача 2. Выводим список на экран
        System.out.println("Список студентов (ArrayList):");
        System.out.println(studentNames);
        System.out.println("Количество элементов в списке: " + studentNames.size());
        System.out.println();

        // Задача 3. Передаем все элементы из ArrayList в множество (HashSet).
        Set<String> uniqueNames = new HashSet<>(studentNames);

        System.out.println("Уникальные студенты (HashSet):");
        System.out.println(uniqueNames);
        System.out.println("Количество уникальных имён: " + uniqueNames.size());
        System.out.println();

        // Задача 4. Создаем словарь (HashMap): ключ — имя студента, значение — итоговый балл.
        Map<String, Integer> studentScores = new HashMap<>();

        // Задача 5. Заполняем словарь оценками (целые числа от 1 до 100).
        studentScores.put("Анна", 95);
        studentScores.put("Борис", 78);
        studentScores.put("Виктор", 64);
        studentScores.put("Галина", 88);

        // Выводим результаты на экран.
        System.out.println("Журнал оценок (HashMap):");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println("  Студент: " + entry.getKey() + " -> Балл: " + entry.getValue());
        }
    }
}
