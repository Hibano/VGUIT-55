package Java1112; // Задание 10: Коллекции (ArrayList) — Работа с динамическими массивами

import java.util.ArrayList;
import java.util.Collections;


    public class Zadanie10 {

        public static void main(String[] args) {
            ArrayList<String> fruits = new ArrayList<>();
            fruits.add("Яблоко");
            fruits.add("Банан");
            fruits.add("Апельсин");
            fruits.add("Киви");
            fruits.add("Манго");

            System.out.println("Список фруктов:");
            for (String fruit : fruits) {
                System.out.println("- " + fruit);
            }

            fruits.remove(2); // удаляем "Апельсин"
            System.out.println("\nПосле удаления третьего элемента:");
            for (String fruit : fruits) {
                System.out.println("- " + fruit);
            }

            // проверяем, содержит ли список "Яблоко"
            boolean hasApple = fruits.contains("Яблоко");
            System.out.println("\nСодержит 'Яблоко'? " + hasApple);

            // сортировка по алфавиту
            Collections.sort(fruits);
            System.out.println("\nОтсортированный список:");
            for (String fruit : fruits) {
                System.out.println("- " + fruit);
            }

            // сортировка списка имен по букве А
            System.out.println("\nИмена на букву 'А':");
            ArrayList<String> names = new ArrayList<>();
            names.add("Александр");
            names.add("Борис");
            names.add("Анна");
            names.add("Дмитрий");
            names.add("Алексей");

            for (String name : names) {
                if (name.startsWith("А")) {
                    System.out.println(name);
                }
            }
        }
    }
