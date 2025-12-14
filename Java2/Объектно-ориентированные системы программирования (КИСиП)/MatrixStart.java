import java.util.Scanner;

public class MatrixStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("--- Матрица A ---");
            System.out.print("Введите количество строк для матрицы A: ");
            int rowsA = scanner.nextInt();
            System.out.print("Введите количество столбцов для матрицы A: ");
            int colsA = scanner.nextInt();
            MatrixPlus matrixA = new MatrixPlus(rowsA, colsA);
            matrixA.inputMatrix();
            matrixA.printMatrix();

            System.out.println("\n--- Матрица B (того же размера для сложения/вычитания) ---");
            MatrixPlus matrixB = new MatrixPlus(rowsA, colsA); // Создаем того же размера
            matrixB.inputMatrix();
            matrixB.printMatrix();

            System.out.println("\n--- Результаты операций ---");

            MatrixPlus matrixSum = matrixA.add(matrixB);
            System.out.println("Сумма A + B:");
            matrixSum.printMatrix();


            MatrixPlus matrixDiff = matrixA.subtract(matrixB);
            System.out.println("Разность A - B:");
            matrixDiff.printMatrix();


            if (rowsA > 0 && colsA > 0) {

                System.out.println("\n--- Дополнительные методы для A ---");
                matrixA.printRow(0);
                matrixA.printColumn(0);
            }


            if (rowsA == colsA) {
                matrixA.printMainDiagonal();
                matrixA.printSecondaryDiagonal();
            } else {
                System.out.println("Матрица A не является квадратной, диагонали не печатаются.");
            }

        } catch (IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Ошибка ввода: ожидалось числовое значение.");
        } finally {
            scanner.close();
        }
    }
}