import java.util.List;
import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("\n=== МЕНЮ КАЛЬКУЛЯТОРА ===");
        System.out.println("1. Рассчитать выражение");
        System.out.println("2. Просмотр истории");
        System.out.println("3. Экспорт всей истории в файл");
        System.out.println("4. Выбрать и сохранить уравнения в файл");
        System.out.println("5. Выход");
        System.out.print("Выберите действие: ");
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void printHistory(List<String> history) {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
            return;
        }
        System.out.println("\n--- ИСТОРИЯ ВЫЧИСЛЕНИЙ ---");
        for (int i = 0; i < history.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, history.get(i));
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String error) {
        System.out.println("Ошибка: " + error);
    }
}
