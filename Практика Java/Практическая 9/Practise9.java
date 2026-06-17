import java.util.InputMismatchException;
import java.util.Scanner;

public class Practise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Задание 1 Запрос двух целых чисел
            System.out.print("Введите первое целое число (делимое): ");
            int number1 = scanner.nextInt();

            System.out.print("Введите второе целое число (делитель): ");
            int number2 = scanner.nextInt();

            // Задание 2 Выполнение деления
            int result = number1 / number2;
            System.out.println("Результат деления: " + result);

        } catch (InputMismatchException e) {
            // Задание 3 Исключения
            System.out.println("Ошибка: Вы ввели не целое число!");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль запрещено!");
            // Задание 4 Блок finally
        } finally {
            System.out.println("Программа завершила работу.");
            scanner.close();}}}