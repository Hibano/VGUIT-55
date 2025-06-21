import java.util.Scanner;

public class PowerSumCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод числа и степени начала ряда
        System.out.print("Введите положительное число: ");
        int number = scanner.nextInt();

        System.out.print("Введите начальную степень: ");
        int startPower = scanner.nextInt();

        if (isValid(number, startPower)) {
            System.out.println("Сумма степеней цифр равна числу, умноженному на множитель из 2^6.");
        } else {
            System.out.println("Не удалось найти такой множитель.");
        }

        scanner.close();
    }

    // Функция проверки условия
    public static boolean isValid(int number, int startPower) {
        String numStr = String.valueOf(number);
        int sum = 0;
        int power = startPower;

        // Вычисление суммы степеней цифр
        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            sum += Math.pow(digit, power);
            power++;
        }

        // Проверка делимости на исходное число
        if (sum % number != 0) {
            return false;
        }

        int multiplier = sum / number;

        // Проверка, является ли множитель степенью двойки от 1 до 2^6
        for (int i = 1; i <= 6; i++) {
            if (multiplier == Math.pow(2, i)) {
                return true;
            }
        }

        return false;
    }
}