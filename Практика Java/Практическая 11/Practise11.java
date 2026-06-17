import java.util.*;
import java.util.stream.Collectors;

public class Practise11 {
    public static void main(String[] args) {
        // Задача 1 Создаем ArrayList с числами
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, -2, 3, -4, 5));

        // Задача 2 Обработка с помощью Stream API
        List<Integer> result = numbers.stream()
                .filter(n -> n > 0)          // A. Отфильтровать только положительные
                .map(n -> n * n)             // B. Возвести их в квадрат
                .collect(Collectors.toList()); // C. Собрать в новый список

        // Задача 3 Вывод исходного и итогового списков
        System.out.println("Исходный список: " + numbers);
        System.out.println("Итоговый список: " + result);
    }
}
