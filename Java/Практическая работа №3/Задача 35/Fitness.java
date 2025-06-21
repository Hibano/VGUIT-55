import java.util.Arrays;

public class Fitness {
    public static void main(String[] args) {
        String input = "56 65 74 100 99 68 86 180 90";

        String[] weights = input.split(" ");

        Arrays.sort(weights, (a, b) -> {
            int sumA = a.chars().map(c -> c - '0').sum();
            int sumB = b.chars().map(c -> c - '0').sum();
            return sumA != sumB ? sumA - sumB : a.compareTo(b);
        });

        System.out.println(String.join(" ", weights));
    }
}