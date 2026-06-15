import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.printMenu();
            String choice = view.readString("");
            switch (choice) {
                case "1" -> handleCalculation();
                case "2" -> view.printHistory(model.getHistory());
                case "3" -> handleExportAll();
                case "4" -> handleExportSelected();
                case "5" -> {
                    view.printMessage("Завершение работы.");
                    return;
                }
                default -> view.printError("Неверный пункт меню.");
            }
        }
    }

    private void handleCalculation() {
        String exp = view.readString("Введите выражение: ");
        try {
            double res = model.evaluate(exp);
            view.printMessage("Результат: " + res);
            model.addToHistory(exp, res);
        } catch (Exception e) {
            view.printError(e.getLocalizedMessage());
        }
    }

    private void handleExportAll() {
        String pathInput = view.readString("Введите имя файла или путь (оставьте пустым для дефолта): ");
        String resolvedPath = model.resolvePath(pathInput);

        if (pathInput.trim().isEmpty()) {
            view.printMessage("Текущий файл истории находится тут: " + resolvedPath);
            return;
        }

        try {
            model.saveSelectedToFile(model.getHistory(), resolvedPath);
            view.printMessage("Успешно сохранено по пути: " + resolvedPath);
        } catch (IOException e) {
            view.printError("Не удалось сохранить файл: " + e.getMessage());
        }
    }

    private void handleExportSelected() {
        List<String> history = model.getHistory();
        if (history.isEmpty()) {
            view.printError("История пуста. Нечего выбирать.");
            return;
        }

        view.printHistory(history);
        String indexesInput = view.readString("Введите номера уравнений через запятую (напр. 1,3): ");
        String pathInput = view.readString("Введите путь для сохранения: ");

        try {
            List<String> selected = new ArrayList<>();
            String[] tokens = indexesInput.split(",");
            for (String token : tokens) {
                int idx = Integer.parseInt(token.trim()) - 1;
                if (idx >= 0 && idx < history.size()) {
                    selected.add(history.get(idx));
                }
            }

            if (selected.isEmpty()) {
                view.printError("Не выбрано ни одного корректного уравнения.");
                return;
            }

            String resolvedPath = model.resolvePath(pathInput);
            model.saveSelectedToFile(selected, resolvedPath);
            view.printMessage("Выбранные записи успешно сохранены по пути: " + resolvedPath);

        } catch (NumberFormatException e) {
            view.printError("Неверный формат ввода номеров. Используйте цифры и запятые.");
        } catch (IOException e) {
            view.printError("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
