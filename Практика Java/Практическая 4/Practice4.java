public class Practice4 {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 7, 42, 18};
        int sum = 0;
        int max = numbers[0];
        boolean has42 = false;

        System.out.print("Элементы массива: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            sum += numbers[i];
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] == 42) has42 = true;
        }

        System.out.println("\nСумма элементов: " + sum);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Массив содержит число 42: " + has42);
    }
}