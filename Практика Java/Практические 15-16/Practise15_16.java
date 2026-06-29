import java.util.Arrays;
import java.util.Random;

public class Practise15_16 {
    public static void main(String[] args) {
        // Задача 1. Одномерный массив случайных чисел.
        // Линейный поиск максимума и минимума.
        Random random = new Random();
        int[] numbers = new int[10];

        // Заполняем массив случайными числами от 0 до 99.
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Задача 1. Одномерный массив:");
        System.out.println(Arrays.toString(numbers));

        // Линейный поиск: считаем первый элемент и максимумом, и минимумом,
        // затем проходим по остальным элементам и сравниваем.
        int max = numbers[0];
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
        System.out.println();

        // Задача 2. Квадратная матрица: единичная главная диагональ.
        // Элементы, где i == j, равны 1, остальные — 0.
        int size = 5;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {          // внешний цикл — строки
            for (int j = 0; j < size; j++) {      // внутренний цикл — столбцы
                if (i == j) {
                    matrix[i][j] = 1;             // главная диагональ
                } else {
                    matrix[i][j] = 0;             // остальные элементы
                }
            }
        }

        System.out.println("Задача 2. Единичная матрица (главная диагональ):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();                 // новая строка
        }
        System.out.println();

        // Задача 3. (опционально). Ступенчатый массив — треугольник Паскаля.
        // Каждая строка длиннее предыдущей. Крайние элементы = 1,
        // внутренние = сумма двух элементов строки выше.
        int rows = 6;
        int[][] pascal = new int[rows][];         // объявляем количество строк, длину — отдельно

        for (int i = 0; i < rows; i++) {
            pascal[i] = new int[i + 1];           // i-я строка содержит (i + 1) элемент
            pascal[i][0] = 1;                     // первый элемент строки всегда 1
            pascal[i][i] = 1;                     // последний элемент строки всегда 1

            // Внутренние элементы — сумма двух соседей из предыдущей строки.
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        System.out.println("Задача 3. Треугольник Паскаля (ступенчатый массив):");
        for (int i = 0; i < rows; i++) {
            // Небольшой отступ для красивого «треугольника».
            for (int s = 0; s < rows - i; s++) {
                System.out.print("  ");
            }
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.printf("%4d", pascal[i][j]);
            }
            System.out.println();
        }
    }
}
