import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите строку: ");
        String text = scanner.nextLine();


        System.out.print("Введите число сдвига: ");
        int shift = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Введите направление (влево или вправо): ");
        String direction = scanner.nextLine().toLowerCase();


        if (direction.equals("влево")) {
            shift = -shift;
        }


        String upper = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String lower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // заглавные буквы
            if (upper.indexOf(c) != -1) {
                int index = upper.indexOf(c);
                int newIndex = (index + shift) % 33;
                if (newIndex < 0) newIndex += 33;
                result.append(upper.charAt(newIndex));
            }
            // маленькие буквы
            else if (lower.indexOf(c) != -1) {
                int index = lower.indexOf(c);
                int newIndex = (index + shift) % 33;
                if (newIndex < 0) newIndex += 33;
                result.append(lower.charAt(newIndex));
            }

            else {
                result.append(c);
            }
        }

        
        System.out.println("Зашифрованная строка: " + result.toString());
    }
}