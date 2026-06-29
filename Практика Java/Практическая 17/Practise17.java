import java.util.HashMap;
import java.util.Map;

public class Practise17 {
    public static void main(String[] args) {

        // Задача 1. Создаём коллекцию HashMap: ключ — имя, значение — оценка.
        HashMap<String, Integer> journal = new HashMap<>();

        // Задача 2. Заполняем журнал данными пяти разных студентов (оценки от 1 до 100).
        journal.put("Иван", 85);
        journal.put("Мария", 92);
        journal.put("Пётр", 73);
        journal.put("Ольга", 100);
        journal.put("Сергей", 56);

        // Задача 3. Выводим на экран оценку конкретного студента по его имени (метод get()).
        String searchName = "Мария";
        System.out.println("Оценка студента \"" + searchName + "\": " + journal.get(searchName));
        System.out.println();

        // Задача 4. Проверяем, есть ли в журнале студент "Иван" (метод containsKey()).
        String checkName = "Иван";
        boolean hasStudent = journal.containsKey(checkName);
        if (hasStudent) {
            System.out.println("Студент \"" + checkName + "\" есть в журнале.");
        } else {
            System.out.println("Студента \"" + checkName + "\" нет в журнале.");
        }
        System.out.println();

        // Задача 5. Удаляем одного студента из журнала (метод remove()).
        String removeName = "Пётр";
        journal.remove(removeName);
        System.out.println("Студент \"" + removeName + "\" удалён из журнала.");
        System.out.println();
        // Выводим весь оставшийся список на экран.
        System.out.println("Оставшийся список студентов:");
        for (Map.Entry<String, Integer> entry : journal.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
