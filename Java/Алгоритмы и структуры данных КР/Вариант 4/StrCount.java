public class StrCount {
    public static void main(String[] args) {
        String text = "Hello Motto";
        char symbol = 'o';
        int count = strCount(text, symbol);
        System.out.println("Количество вхождений: " + count);
    }

    public static int strCount(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}