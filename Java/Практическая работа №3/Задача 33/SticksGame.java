public class SticksGame {
    public static void main(String[] args) throws Exception {
        long n = 0;
        int ch;

        // Считываем число палочек
        while ((ch = System.in.read()) != '\n') {
            if (ch >= '0' && ch <= '9') {
                n = n * 10 + (ch - '0');
            }
        }

        boolean sasha = true; // Саша ходит первым

        // Игра продолжается, пока есть палочки
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2; // Если чётное — берём половину
            } else {
                n--;    // Если нечётное — берём одну палочку
            }
            sasha = !sasha;
        }

        if (sasha) {
            System.out.println("Таня победила");
        } else {
            System.out.println("Саша победил");
        }
    }
}