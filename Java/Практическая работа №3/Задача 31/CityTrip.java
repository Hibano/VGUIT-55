import java.util.Arrays;

public class CityTrip {

    static int bestSum = -1;
    static int[] bestCombo = null;

    public static int[] chooseBestSum(int maxDist, int count, int[] towns) {
        findBest(towns, count, 0, 0, 0, maxDist, new int[count]);
        return bestCombo;
    }

    static void findBest(int[] towns, int count, int start, int depth, int sum, int maxDist, int[] current) {
        if (depth == count) {
            if (sum <= maxDist && sum > bestSum) {
                bestSum = sum;
                bestCombo = Arrays.copyOf(current, count);
            }
            return;
        }

        for (int i = start; i < towns.length; i++) {
            current[depth] = towns[i];
            findBest(towns, count, i + 1, depth + 1, sum + towns[i], maxDist, current);
        }
    }

    public static void main(String[] args) {
        int[] l = {50, 55, 57, 58, 60};
        int[] result = chooseBestSum(175, 3, l);
        System.out.println("Выбранные города: " + Arrays.toString(result));
        System.out.println("Сумма расстояний: " + (result != null ? Arrays.stream(result).sum() : "Нет решения"));
    }
}