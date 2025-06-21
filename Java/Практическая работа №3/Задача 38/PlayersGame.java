import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayersGame {

    public static List<Integer> playGame(int numberOfPlayers, int startingPlayer) {
        if (numberOfPlayers <= 0) {
            System.out.println("Количество игроков должно быть положительным числом.");
            return new ArrayList<>();
        }
        if (startingPlayer <= 0 || startingPlayer > numberOfPlayers) {
            System.out.println("Некорректный номер начального игрока.");
            return new ArrayList<>();
        }


        List<Integer> players = IntStream.rangeClosed(1, numberOfPlayers)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        List<Integer> eliminatedOrder = new ArrayList<>();

        int currentIndex = startingPlayer - 1;

        System.out.println(players + " - начальная последовательность");

        while (players.size() > 1) {
            int removalIndex = (currentIndex + 2) % players.size();

            // Удаляем игрока из списка
            int eliminatedPlayer = players.remove(removalIndex);
            eliminatedOrder.add(eliminatedPlayer);

            // Вывод хода игры
            System.out.printf("%s => %d выбывает и попадает в результат %s%n",
                    players, eliminatedPlayer, eliminatedOrder);

            currentIndex = removalIndex;

            if (currentIndex >= players.size()) {
                currentIndex = 0;
            }
        }


        if (!players.isEmpty()) {
            int winner = players.remove(0); // Последний игрок
            eliminatedOrder.add(winner);
            System.out.printf("%s => %d выбывает и попадает в результат %s%n",
                    players, winner, eliminatedOrder);
        }

        return eliminatedOrder;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        int playerCount = scanner.nextInt();

        System.out.print("Введите номер игрока, с которого начнётся игра: ");
        int startPlayer = scanner.nextInt();

        System.out.println("\nХод игры:");

        List<Integer> result = playGame(playerCount, startPlayer);

        if (!result.isEmpty()) {
            // Получаем победителя - это последний элемент в списке выбывших
            int winner = result.get(result.size() - 1);
            System.out.println("\nИгра окончена. Победитель: " + winner);
        }

        scanner.close();
    }
}