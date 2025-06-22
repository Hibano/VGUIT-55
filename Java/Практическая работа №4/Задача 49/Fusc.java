public class Fusc {

    public static int fuscRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n % 2 == 0) {
            return fuscRecursive(n / 2);
        } else {
            return fuscRecursive(n / 2) + fuscRecursive(n / 2 + 1);
        }
    }

    private static int F_tailRecursive(int a, int b, int k) {
        if (k == 0) {
            return b;
        }

        if (k % 2 == 0) {
            return F_tailRecursive(a + b, b, k / 2);
        } else {
            return F_tailRecursive(a, a + b, (k - 1) / 2);
        }
    }

    public static int fuscTailRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        return F_tailRecursive(1, 0, n);
    }

    public static int fuscIterative(int n) {
        if (n == 0) {
            return 0;
        }


        int a = 1;
        int b = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                int nextA = a + b;
                int nextB = b;
                a = nextA;
                b = nextB;
                n /= 2;
            } else {
                int nextA = a;
                int nextB = a + b;
                a = nextA;
                b = nextB;
                n = (n - 1) / 2;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("Тестирование fusc(n):");
        for (int i = 0; i <= 10; i++) {
            System.out.println("fusc(" + i + ") (рекурсивный) = " + fuscRecursive(i));
            System.out.println("fusc(" + i + ") (хвостовая рекурсия) = " + fuscTailRecursive(i));
            System.out.println("fusc(" + i + ") (итеративный) = " + fuscIterative(i));
            System.out.println("---");
        }

        System.out.println("\nТестирование итеративной fusc для больших чисел:");
        System.out.println("fusc(100) = " + fuscIterative(100));
        System.out.println("fusc(1000) = " + fuscIterative(1000));
        System.out.println("fusc(10000) = " + fuscIterative(10000));
    }
}