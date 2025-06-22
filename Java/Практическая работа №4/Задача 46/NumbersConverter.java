import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class NumbersConverter {
    
    private static final Map<Character, Integer> ROMAN_VALUES = new HashMap<>();
    static {
        ROMAN_VALUES.put('I', 1);
        ROMAN_VALUES.put('V', 5);
        ROMAN_VALUES.put('X', 10);
        ROMAN_VALUES.put('L', 50);
        ROMAN_VALUES.put('C', 100);
        ROMAN_VALUES.put('D', 500);
        ROMAN_VALUES.put('M', 1000);
    }

    public static int toArabic(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Римское число не может быть пустым.");
        }

        roman = roman.toUpperCase(); // Преобразуем в верхний регистр для удобства
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            Integer currentValue = ROMAN_VALUES.get(currentChar);

            if (currentValue == null) {
                throw new IllegalArgumentException("Некорректный символ в римском числе: " + currentChar);
            }

            // Если текущее значение меньше предыдущего (например, 'I' перед 'V' в 'IV'), вычитаем
            if (currentValue < prevValue) {
                result -= currentValue;
            } else { // Иначе - добавляем
                result += currentValue;
            }
            prevValue = currentValue; // Обновляем предыдущее значение
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Конвертер римских чисел в арабские ---");
        System.out.print("Введите римское число (например, XIV, MCMXCIV): ");

        try {
            String romanInput = scanner.nextLine();
            int arabicResult = toArabic(romanInput);
            System.out.println("Арабское представление: " + arabicResult);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}