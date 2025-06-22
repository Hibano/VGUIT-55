import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnailMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число N (количество чисел для генерации): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("N должно быть положительным числом.");
            return;
        }

        int size = (int) Math.ceil(Math.sqrt(n));
        int[][] matrix = new int[size][size];

        // Заполняем матрицу случайными числами
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(100); // Генерируем случайные числа от 0 до 99
            }
        }

        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        List<Integer> result = snail(matrix);
        System.out.println("Результат 'змейки': " + result);

        scanner.close();
    }

    public static List<Integer> snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0 || array[0].length == 0) {
            return result;
        }

        int rows = array.length;
        int cols = array[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(array[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(array[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}