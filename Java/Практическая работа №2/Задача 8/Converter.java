import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int upperCount = 0;
        int lowerCount = 0;

        // Подсчет количества заглавных и строчных букв
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }

        String result;
        if (upperCount > lowerCount) {
            result = input.toUpperCase();
        } else if (lowerCount > upperCount) {
            result = input.toLowerCase();
        } else {
            // Если количество заглавных и строчных равно
            result = input.toLowerCase();
        }

        System.out.println(result);
        scanner.close();
    }
}