// Задача 1 Класс Book
class Book {
    // Приватные поля
    private String title;
    private String author;
    private int year;

    // Задача 2 Конструктор инициализирующий все поля
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Задача 3 Get и set для всех полей
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    // Задача 4 Метод для вывода информации о книге
    public void displayInfo() {
        System.out.println("Книга: \"" + title + "\", Автор: " + author + ", Год: " + year);
    }
}

public class Practise6 {
    // Задача 5 Точка входа main() и создание двух объектов класса Book
    public static void main(String[] args) {

        Book book1 = new Book("Капитанская дочка", "А.С. Пушкин", 1836);
        Book book2 = new Book("Преступление и наказание", "Ф.М. Достоевский", 1866);

        // Вызов для демонстрации работы
        book1.displayInfo();
        book2.displayInfo();

        // Пример использования get и set
        book1.setYear(1837);
        System.out.println("Измененный год первой книги: " + book1.getYear());
    }
}
