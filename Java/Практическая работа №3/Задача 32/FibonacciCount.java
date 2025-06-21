import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciCount {

    public static BigInteger fibonacci(int n) {
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return n == 0 ? a : b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i < 10 || i > 100000) {
            System.out.println("Ошибка: i вне диапазона");
            return;
        }

        BigInteger fib = fibonacci(i);
        String s = fib.toString();

        int[] counts = new int[10];
        for (char c : s.toCharArray()) counts[c - '0']++;

        int maxCount = 0, digit = 0;
        for (int d = 9; d >= 0; d--) {
            if (counts[d] > maxCount) {
                maxCount = counts[d];
                digit = d;
            }
        }

        System.out.printf("f(%d) = %s\n[(%d, %d)]\n", i, s, maxCount, digit);
    }
}