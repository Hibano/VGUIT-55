import java.util.Scanner;

public class EqualDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String input = scanner.nextLine();


        String[] words = input.split(" ");

        String result = "";

        for (int i = 0; i < words.length; i++) {
            boolean isDuplicate = false;


            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    isDuplicate = true;
                    break;
                }
            }


            if (!isDuplicate) {
                if (!result.equals("")) {
                    result += " ";
                }
                result += words[i];
            }
        }

        System.out.println(result);
    }
}