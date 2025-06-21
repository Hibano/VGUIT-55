import java.util.Scanner;

public class SticksGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long tanyaSticks = 0;
        boolean tanyaTurn = true;

        while (n > 0) {
            if (tanyaTurn) {
                // Ход Тани
                if (n % 2 == 0) {
                    // Таня берет 1 палочку при четном n
                    tanyaSticks += 1;
                    n -= 1;
                } else {
                    // Нечетное, Таня берет 1 палочку
                    tanyaSticks += 1;
                    n -= 1;
                }
            } else {
                // Ход Саши - жадный ход
                if (n % 2 == 0) {
                    long half = n / 2;
                    n -= half;
                } else {
                    n -= 1;
                }
            }
            tanyaTurn = !tanyaTurn;
        }

        System.out.println(tanyaSticks);
    }
}