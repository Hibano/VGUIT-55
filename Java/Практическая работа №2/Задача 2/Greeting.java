import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String inputName = scanner.nextLine().trim();

        // Приводим первую букву к верхнему регистру, остальные — к нижнему
        if (!inputName.isEmpty()) {
            String formattedName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1).toLowerCase();
            System.out.println("Привет, " + formattedName + "!");
        } else {
            System.out.println("Имя не введено.");
        }
    }
}
