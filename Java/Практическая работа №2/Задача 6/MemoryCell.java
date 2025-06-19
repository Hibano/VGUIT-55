import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemoryCell {
    private static final int MAX_SIZE = 3;
    private final ArrayList<Integer> memory = new ArrayList<>();

    public void addNumber(int number) {
        if (memory.size() < MAX_SIZE) {
            memory.add(number);
        } else {
            int min = Collections.min(memory);
            if (number > min) {
                int index = memory.indexOf(min);
                memory.set(index, number);
            }
        }
    }

    public void printMemory() {
        System.out.println("Текущее состояние памяти: " + memory);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemoryCell cell = new MemoryCell();

        System.out.println("Введите числа или 'exit' для завершения:");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                cell.addNumber(number);
                cell.printMemory();
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Введите число или 'exit'.");
                }
            }
        }
        scanner.close();
    }
}