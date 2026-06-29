public class Practise14 {
    // Задача 3.
    public static void main(String[] args) {
        System.out.println("Основной поток: запускаем две задачи параллельно.");
        // Создаём экземпляры задач.
        Runnable numberTask = new NumberTask();
        Runnable letterTask = new LetterTask();
        // Оборачиваем каждую задачу в отдельный поток.
        Thread numberThread = new Thread(numberTask, "ПотокЧисел");
        Thread letterThread = new Thread(letterTask, "ПотокБукв");
        // Запускаем оба потока методом start().
        // Именно start() (а не run()) создаёт новую параллельную ветку выполнения.
        numberThread.start();
        letterThread.start();
        // Заставляем главный поток дождаться завершения обоих рабочих потоков.
        try {
            numberThread.join();
            letterThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Основной поток: обе задачи завершены.");
        // Анализ порядка вывода:
        // Числа печатаются каждые 500 мс, буквы — каждые 700 мс, поэтому строки
        // чередуются и появляются вперемешку. Точный порядок зависит от планировщика
        // потоков ОС и может немного отличаться при каждом запуске программы.
    }
}

// Задача 1. Выводим числа от 1 до 5 с задержкой 500 мс.
class NumberTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Число: " + i);
            try {
                // Приостанавливаем поток на 500 миллисекунд.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Если поток прервали во время ожидания — восстанавливаем флаг прерывания.
                Thread.currentThread().interrupt();
                System.out.println("Поток с числами был прерван.");
            }
        }
    }
}

// Задача 2. Выводим буквы от 'A' до 'E' с задержкой 700 мс.
class LetterTask implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Буква: " + c);
            try {
                // Приостанавливаем поток на 700 миллисекунд.
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток с буквами был прерван.");
            }
        }
    }
}
