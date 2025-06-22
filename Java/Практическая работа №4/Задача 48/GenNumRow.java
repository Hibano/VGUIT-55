import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class GenNumRow {

    public static void main(String[] args) {
        int count = 15; // Желаемое количество уникальных чисел в ряду u
        System.out.println("Генерация ряда u с " + count + " уникальными числами:");
        generateUSequence(count);
    }

    public static void generateUSequence(int count) {
        // TreeSet автоматически сортирует элементы и предотвращает дубликаты
        SortedSet<Long> uSet = new TreeSet<>();
        Queue<Long> queue = new LinkedList<>();

        // Начальное условие u(0) = 1
        uSet.add(1L);
        queue.add(1L);

        long currentNum;
        int generatedCount = 0;

        while (!queue.isEmpty() && generatedCount < count) {
            currentNum = queue.poll(); // Берем наименьшее число для обработки

            if (generatedCount == 0 && currentNum == 1) {
                generatedCount++;
                if (generatedCount == count) break;
            }

            // Генерируем y
            long y = 2 * currentNum + 1;
            if (uSet.add(y)) { // Если y уникально и добавлено
                queue.add(y);
                generatedCount++;
                if (generatedCount == count) break;
            }

            // Генерируем z
            long z = 3 * currentNum + 1;
            if (uSet.add(z)) { // Если z уникально и добавлено
                queue.add(z);
                generatedCount++;
                if (generatedCount == count) break;
            }
        }

        // Выводим полученный ряд
        System.out.println("Ряд u: " + uSet);
    }
}