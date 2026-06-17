public class Practise5 {

    // Задача 1 Сумма двух чисел
    public static int sum(int a, int b) {
        return a + b;
    }

    // Задача 2 Перегруженный метод для суммы трех чисел
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // Задача 3 Метод проверяет, чётное ли число
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Задача 4 Метод выводит сообщение на экран
    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Задача 5 Вызов всех методов для демонстрации
    public static void main(String[] args) {
        // Демонстрация метода sum(a, b)
        int result2 = sum(5, 10);
        System.out.println("Сумма двух чисел (5 + 10): " + result2);

        // Демонстрация метода sum(a, b, c)
        int result3 = sum(10, 20, 30);
        System.out.println("Сумма трех чисел (10 + 20 + 30): " + result3);

        // Демонстрация метода isEven(number)
        int checkNumber = 8;
        boolean evenResult = isEven(checkNumber);
        System.out.println("Число " + checkNumber + " чётное? " + evenResult);

        // Демонстрация метода printMessage(message)
        printMessage("Привет! Все методы успешно протестированы.");
    }
}