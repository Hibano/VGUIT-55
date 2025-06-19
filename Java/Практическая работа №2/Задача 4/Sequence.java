import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите два числа через пробел: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int step = Math.min(a, b);
        int count = Math.max(a, b);
        for (int i = 1; i <= count; i++) {
            int number = i * step;
            System.out.print((number * number) + " ");
        }
    }
}