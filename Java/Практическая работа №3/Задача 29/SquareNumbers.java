import java.util.Scanner;

public class SquareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // Разность квадратов двух последовательных чисел всегда нечётная
        // проверим что число нечётное и входит в допустимые границы
        if (n <= 0 || n > 100000 || n % 2 == 0) {
            System.out.println("Ошибка, n должно быть нечётным числом от 1 до 100000");
            return;
        }

        int b = (n - 1) / 2;
        int a = b + 1;

        int firstSquare = b * b;
        int secondSquare = a * a;

        System.out.println(n + " = " + secondSquare + " - " + firstSquare);
    }
}