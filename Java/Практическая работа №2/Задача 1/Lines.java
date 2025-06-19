import java.util.Scanner;

public class Lines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод первой строки
        System.out.print("Введите первую строку: ");
        String first = scanner.nextLine();

        // Ввод второй строки
        System.out.print("Введите вторую строку: ");
        String second = scanner.nextLine();

        // Проверка, заканчивается ли первая строка второй
        boolean result = first.endsWith(second);

        // Вывод результата
        System.out.println(result);
    }
}