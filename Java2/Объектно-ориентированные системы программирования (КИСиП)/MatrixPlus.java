import java.util.Scanner;
import java.lang.IllegalArgumentException;

public class MatrixPlus {
    private double[][] data;
    private final int rows; // Количество строк
    private final int columns; // Количество столбцов




    public MatrixPlus(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Размеры матрицы должны быть положительными числами.");
        }
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы матрицы " + rows + "x" + columns + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("data[" + i + "][" + j + "]: ");
                if (scanner.hasNextDouble()) {
                    this.data[i][j] = scanner.nextDouble();
                } else {
                    System.out.println("Ошибка ввода. Пожалуйста, введите числовое значение.");
                    scanner.next(); // Очистка буфера сканера
                    j--; // Повторить текущую итерацию
                }
            }
        }
    }


    public MatrixPlus add(MatrixPlus other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры для сложения.");
        }

        MatrixPlus result = new MatrixPlus(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }


    public MatrixPlus subtract(MatrixPlus other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры для вычитания.");
        }

        MatrixPlus result = new MatrixPlus(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }


    public MatrixPlus multiply(MatrixPlus other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно быть равно количеству строк второй матрицы для умножения.");
        }

        MatrixPlus result = new MatrixPlus(this.rows, other.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    public void printMatrix() {
        System.out.println("Матрица (" + rows + "x" + columns + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%.2f\t", data[i][j]);
            }
            System.out.println();
        }
    }

    public void printRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows) {
            throw new IndexOutOfBoundsException("Неверный индекс строки.");
        }
        System.out.print("Строка " + rowIndex + ": ");
        for (int j = 0; j < columns; j++) {
            System.out.printf("%.2f\t", data[rowIndex][j]);
        }
        System.out.println();
    }

    public void printColumn(int colIndex) {
        if (colIndex < 0 || colIndex >= columns) {
            throw new IndexOutOfBoundsException("Неверный индекс столбца.");
        }
        System.out.println("Столбец " + colIndex + ":");
        for (int i = 0; i < rows; i++) {
            System.out.printf("%.2f\n", data[i][colIndex]);
        }
    }

    public void printMainDiagonal() {
        if (rows != columns) {
            throw new IllegalStateException("Матрица должна быть квадратной для печати главной диагонали.");
        }
        System.out.print("Главная диагональ: ");
        for (int i = 0; i < rows; i++) {
            System.out.printf("%.2f\t", data[i][i]);
        }
        System.out.println();
    }

    public void printSecondaryDiagonal() {
        if (rows != columns) {
            throw new IllegalStateException("Матрица должна быть квадратной для печати побочной диагонали.");
        }
        System.out.print("Побочная диагональ: ");
        for (int i = 0; i < rows; i++) {
            System.out.printf("%.2f\t", data[i][columns - 1 - i]);
        }
        System.out.println();
    }
}