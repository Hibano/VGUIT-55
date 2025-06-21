import java.util.Random;
import java.util.Scanner;

public class GuessTheCodeGame {

    public static void main(String[] args) {

        // --- 1. Подготовка к игре ---

        System.out.println("--- Игра 'Угадай код' ---");
        System.out.println("Был сгенерирован секретный код из 4 цифр (от 0 до 9).");
        System.out.println("У тебя есть 20 попыток, чтобы его отгадать.");
        System.out.println("После каждой попытки я скажу, сколько цифр ты угадал.");
        System.out.println("------------------------------------------");

        // Создаем массив для хранения секретного кода
        int[] secretCode = new int[4];

        // Используем класс Random для генерации случайных чисел
        Random random = new Random();

        // Заполняем массив случайными цифрами от 0 до 9
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = random.nextInt(10);
        }

        // Основной игровой цикл

        final int MAX_ATTEMPTS = 20; // Максимальное количество попыток
        boolean isCodeGuessed = false;

        // Создаем Scanner для чтения ввода от пользователя
        Scanner scanner = new Scanner(System.in);

        // Цикл для попыток. Он будет выполняться до 20 раз.
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("\n--- Попытка №" + attempt + " ---");
            System.out.print("Введи 4 цифры (например, 1234): ");

            int userGuessNumber;

            // Проверяем, ввел ли пользователь число
            try {
                userGuessNumber = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка! Пожалуйста, вводи только числа.");
                scanner.next();
                attempt--; // Не засчитываем некорректную попытку
                continue;
            }


            // Проверяем, что число четырехзначное
            if (userGuessNumber < 0 || userGuessNumber > 9999) {
                System.out.println("Ошибка! Нужно ввести ровно 4 цифры (от 0000 до 9999).");
                continue;
            }


            int[] userGuessCode = new int[4];
            userGuessCode[0] = userGuessNumber / 1000;
            userGuessCode[1] = (userGuessNumber / 100) % 10;
            userGuessCode[2] = (userGuessNumber / 10) % 10;
            userGuessCode[3] = userGuessNumber % 10;

            // Сравнение кодов и подсчет совпадений

            int matches = 0; // Счетчик совпадений


            int[] tempSecretCode = secretCode.clone();
            int[] tempUserCode = userGuessCode.clone();


            for(int i = 0; i < 4; i++){
                if(tempSecretCode[i] == tempUserCode[i]){
                    matches++;
                    tempSecretCode[i] = -1;
                    tempUserCode[i] = -2;
                }
            }

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(tempSecretCode[i] != -1 && tempSecretCode[i] == tempUserCode[j]){
                        matches++;
                        tempSecretCode[i] = -1;
                        tempUserCode[j] = -2;
                        break; // Переход к следующей цифре секретного кода
                    }
                }
            }


            // Вывод результата и проверка на победу

            if (matches == 4) {
                isCodeGuessed = true;
                System.out.println("Поздравляю! Ты угадал код!");
                break;
            } else {
                System.out.println("Количество совпадений: " + matches);
            }
        }

        // Завершение игры

        if (!isCodeGuessed) {
            System.out.println("\nУвы, ты проиграл. Попытки закончились.");
            System.out.print("Загаданный код был: ");
            for (int digit : secretCode) {
                System.out.print(digit);
            }
            System.out.println();
        }


        scanner.close();
        System.out.println("Спасибо за игру!");
    }
}