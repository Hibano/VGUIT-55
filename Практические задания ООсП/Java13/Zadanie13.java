package Java13;

import java.util.ArrayList;

class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }

    public void info() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // вызов конструктора родителя
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }

    @Override
    public void info() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Порода: " + breed);
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Чирик-чирик!");
    }
}

public class Zadanie13 {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2);

        dog.makeSound(); // Гав-гав!
        cat.makeSound(); // Мяу!

        System.out.println("\n--- Работа со списком животных ---");
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(new Bird("Кеша", 1));

        for (Animal animal : animals) {
            animal.info();      // Информация о животном
            animal.makeSound(); // Звук животного
            System.out.println("-----------------");
        }
    }
}