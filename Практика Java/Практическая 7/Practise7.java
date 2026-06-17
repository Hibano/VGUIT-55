// Задача 1 Супер-класс Vehicle
class Vehicle {
    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void start() {
        System.out.println("Транспортное средство заведено");
    }
}

// Задача 2 Подкласс Car
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int numberOfDoors) {
        super(brand);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Автомобиль " + brand + " заведён");
    }
}

// Задача 3 Подкласс Motorcycle
class Motorcycle extends Vehicle {
    public Motorcycle(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println("Мотоцикл " + brand + " заведён");
    }
}

// Задача 4 Точка входа программы, создание объектов Car, Motorcycle и вызов метода start()
public class Practise7 {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 4);
        Motorcycle myMotorcycle = new Motorcycle("Yamaha");

        myCar.start();
        myMotorcycle.start();
    }
}