public class Practise18 {
    public static void main(String[] args) {

        // Задача 1. Создаём и сразу инициализируем матрицу 3x3 готовыми значениями.
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Задача 2. Объявляем переменную-аккумулятор для подсчёта общей суммы.
        int sum = 0;

        // Выводим саму матрицу на экран для наглядности.
        System.out.println("Матрица 3x3:");
        for (int i = 0; i < matrix.length; i++) {          // внешний цикл — строки
            for (int j = 0; j < matrix[i].length; j++) {   // внутренний цикл — столбцы
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Задачи 3-4. Вложенный цикл for: последовательно обходим все ячейки матрицы
        // и прибавляем значение текущей ячейки matrix[i][j] к переменной sum.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        // Задача 5. После завершения всех циклов выводим итоговую сумму на экран.
        System.out.println("Сумма всех элементов матрицы: " + sum);
    }
}
