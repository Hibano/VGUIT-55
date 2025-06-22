import java.util.Scanner;

public class NumberConverter {
    public static String convertToRoman(int number) {
        if (number <= 1 || number >= 10000) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 2 до 9999.");
        }

        StringBuilder roman = new StringBuilder();

        // Значения римских цифр в порядке убывания
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Программа конвертации арабских чисел в римские.");
        System.out.println("Введите количество лет (число должно быть в диапазоне от 2 до 9999):");

        try {
            int years = scanner.nextInt();
            String romanYears = convertToRoman(years);
            System.out.println("Римское представление: " + romanYears);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Ошибка: Введите, пожалуйста, целое число.");
        } finally {
            scanner.close();
        }
    }
}