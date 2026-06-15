import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CalculatorModel {
    private static final String HISTORY_FILE = "calculator_history.txt";
    private final List<String> history = new ArrayList<>();

    public CalculatorModel() {
        loadHistory();
    }

    //Логика
    public double evaluate(String expression) throws Exception {
        String prepared = expression.replaceAll("\\s+", "").replace("**", "^");
        return rpnToResult(shuntingYard(prepared));
    }

    private List<String> shuntingYard(String expression) throws Exception {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                output.add(sb.toString());
                continue;
            }

            if (c == '/' && i + 1 < expression.length() && expression.charAt(i + 1) == '/') {
                processOperator("//", stack, output);
                i += 2;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%') {
                processOperator(String.valueOf(c), stack, output);
                i++;
                continue;
            }

            if (c == '(') {
                stack.push("(");
                i++;
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (stack.isEmpty()) throw new IllegalArgumentException("Несогласованные скобки");
                stack.pop();
                i++;
            } else {
                throw new IllegalArgumentException("Неизвестный символ: " + c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) throw new IllegalArgumentException("Несогласованные скобки");
            output.add(stack.pop());
        }
        return output;
    }

    private void processOperator(String op, Stack<String> stack, List<String> output) {
        while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(op)) {
            output.add(stack.pop());
        }
        stack.push(op);
    }

    private int getPrecedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/", "%", "//" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

    private double rpnToResult(List<String> rpn) throws Exception {
        Stack<Double> stack = new Stack<>();
        for (String token : rpn) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                if (stack.size() < 2) throw new IllegalArgumentException("Неверное выражение");
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> {
                        if (b == 0) throw new ArithmeticException("Деление на ноль");
                        stack.push(a / b);
                    }
                    case "//" -> {
                        if (b == 0) throw new ArithmeticException("Деление на ноль");
                        stack.push((double) (long) (a / b));
                    }
                    case "%" -> stack.push(a % b);
                    case "^" -> stack.push(Math.pow(a, b));
                }
            }
        }
        if (stack.size() != 1) throw new IllegalArgumentException("Неверное выражение");
        return stack.pop();
    }

    //Логика работы с историей и файлами
    public void addToHistory(String expression, double result) {
        String record = expression + " = " + result;
        history.add(record);
        saveRecordToFile(record);
    }

    public List<String> getHistory() {
        return history;
    }

    private void saveRecordToFile(String record) {
        try (FileWriter fw = new FileWriter(HISTORY_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(record);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения истории: " + e.getMessage());
        }
    }

    private void loadHistory() {
        File file = new File(HISTORY_FILE);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка загрузки истории: " + e.getMessage());
        }
    }

    public String resolvePath(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Paths.get(HISTORY_FILE).toAbsolutePath().toString();
        }

        File file = new File(input);

        // Абсолютный путь с именем файла
        if (file.isAbsolute() && !file.isDirectory()) {
            return file.getAbsolutePath();
        }

        // Указан только путь (существующая папка)
        if (file.isDirectory()) {
            return Paths.get(input, "log.log").toAbsolutePath().toString();
        }

        // Указано имя файла и разрешенное расширение в текущей папке
        String name = file.getName();
        if (name.endsWith(".txt") || name.endsWith(".log") || name.endsWith(".md")) {
            if (!file.isAbsolute()) {
                return Paths.get(System.getProperty("user.dir"), input).toAbsolutePath().toString();
            }
        }

        // Откат, если путь не подошел под условия
        return Paths.get(input).toAbsolutePath().toString();
    }

    public void saveSelectedToFile(List<String> items, String targetPath) throws IOException {
        File file = new File(targetPath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (String item : items) {
                writer.println(item);
            }
        }
    }
}
