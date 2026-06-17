import java.util.ArrayList;
import java.util.Collections;

public class Practise8 {
    public static void main(String[] args) {
        // Задача 1 ArrayList для хранения задач
        ArrayList<String> tasks = new ArrayList<>();

        // Задача 2 Добавление 3 задач в список ArrayList
        tasks.add("Купить молоко");
        tasks.add("Помыть машину");
        tasks.add("Ваша задача");

        // Задача 3 Вывод всех задач на экран
        System.out.println("Все задачи: " + tasks);

        // Задача 4 Удаление второй задачи
        tasks.remove(1);
        System.out.println("Удаляем вторую задачу " + tasks);

        // Задача 5 Проверка, есть ли в списке задача "Ваша задача"
        boolean hasTask = tasks.contains("Ваша задача");
        System.out.println("Есть ли в списке 'Ваша задача'?: " + hasTask);

        // Задача 6 Сортировка задач по алфавиту
        Collections.sort(tasks);
        System.out.println("Сортировка по алфавиту: " + tasks);
    }
}