import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Practise12 {
    public static void main(String[] args) {
        // Указание формата даты для вывода
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Задача 1 Получение текущей даты
        LocalDate today = LocalDate.now();

        // Задача 2 Создание даты рождения
        LocalDate birthday = LocalDate.of(1995, 3, 15);

        // Задача 3 Расчет возраста в годах
        int age = Period.between(birthday, today).getYears();

        // Задача 4 Расчет дней до следующего дня рождения
        // Создаем день рождения в текущем году
        LocalDate nextBirthday = birthday.withYear(today.getYear());

        // Если день рождения в этом году уже прошел, берем следующий год
        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        // Считаем разницу в днях
        long daysLeft = ChronoUnit.DAYS.between(today, nextBirthday);

        // Задача 5 Вывод всем данных в заданном ранее формате
        System.out.println("Текущая дата: " + today.format(formatter));
        System.out.println("Дата рождения: " + birthday.format(formatter));
        System.out.println("Возраст: " + age + " лет");
        System.out.println("Дней до следующего дня рождения: " + daysLeft);
    }
}
