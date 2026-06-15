import java.util.Scanner;

public class WhileDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;

        do {
            System.out.print("Введите пароль: ");
            password = scanner.nextLine();
            if (!password.equals("java123")) {
                System.out.println("Неверный пароль. Попробуйте снова.");
            }
        } while (!password.equals("java123"));

        System.out.println("Доступ разрешён!");
        scanner.close();
    }
}