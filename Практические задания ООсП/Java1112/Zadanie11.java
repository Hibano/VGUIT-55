package Java1112; // Задание 11: Обработка исключений (try-catch)

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите целое число: ");
            int number = scanner.nextInt();
            int result = 100 / number;
            System.out.println("Результат деления 100 на " + number + ": " + result);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите корректное число (целое)!");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль невозможно!");
        } finally {
            scanner.close();
            System.out.println("Сканнер закрыт.");
        }
    }
}