interface Pet {
    void makeSound();
    void play();
}

enum PetType { DOG, CAT, PARROT }

class Dog implements Pet {
    public void makeSound() { System.out.println("Собака: Гав-гав!"); }
    public void play() { System.out.println("Собака бегает за мячиком."); }
}

class Cat implements Pet {
    public void makeSound() { System.out.println("Кошка: Мяу-мяу!"); }
    public void play() { System.out.println("Кошка играет с лазерной указкой."); }
}

class Parrot implements Pet {
    public void makeSound() { System.out.println("Попугай: Привет!"); }
    public void play() { System.out.println("Попугай качается на качелях."); }
}

class PetFactory {
    public static Pet createPet(PetType type) {
        return switch (type) {
            case DOG -> new Dog();
            case CAT -> new Cat();
            case PARROT -> new Parrot();
        };
    }
}

public class FabricMethod5 {
    public static void main(String[] args) {
        for (PetType type : PetType.values()) {
            System.out.println("--- Управление питомцем ---");
            Pet pet = PetFactory.createPet(type);
            pet.makeSound();
            pet.play();
            System.out.println();
        }
    }
}