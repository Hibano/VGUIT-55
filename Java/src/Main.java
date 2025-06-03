public class Main {
        public static void main(String[] args) {
                int[][] a = {{1, 2}, {3, 4}};
                int[][] b = {{5, 6}, {7, 8}};

                Matrix m1 = new Matrix(a);
                Matrix m2 = new Matrix(b);

                Matrix sum = m1.add(m2);
                Matrix diff = m1.subtract(m2);
                Matrix prod = m1.multiply(m2);

                System.out.println("Сложение:");
                sum.print();

                System.out.println("Вычитание:");
                diff.print();

                System.out.println("Умножение:");
                prod.print();
        }
}