public class NumberStepRepeats {
    public static void main(String[] args) throws Exception {
        int a = System.in.read() - '0'; // начало
        System.in.read(); // пробел
        int d = System.in.read() - '0'; // шаг
        System.in.read(); // пробел
        int n = System.in.read() - '0'; // количество шагов

        for (int i = 0; i < n; i++) {
            int value = a + i * d;
            if (i > 0) System.out.print(", ");
            System.out.print(value);
        }
    }
}