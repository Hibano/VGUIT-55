import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CipherDecoder {

    private static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String FISH_TEXT_URL = "https://fish-text.ru/get?format=html&number=8"; // Достаточно большой текст

    public static void main(String[] args) {
        try {
            // 1. Формирование словаря с сайта
            String fishText = getTextFromUrl(FISH_TEXT_URL, 10000);
            Map<Character, Double> referenceFrequencies = calculateCharacterFrequencies(fishText);

            // Ввод зашифрованного текста
            String encryptedText = "Теэй ийру тй чеп уитумтеьту, пеп сулйч фупемечбцд";

            // Расшифровка
            String decryptedText = decrypt(encryptedText, referenceFrequencies);

            System.out.println("Зашифрованный текст: " + encryptedText);
            System.out.println("Расшифрованный текст: " + decryptedText);

        } catch (IOException e) {
            System.err.println("Ошибка при получении текста для словаря: " + e.getMessage());
        }
    }


    private static String getTextFromUrl(String urlString, int maxLength) throws IOException {
        URL url = new URL(urlString);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Удаляем HTML-теги для чистоты текста
                content.append(line.replaceAll("<[^>]*>", " "));
            }
        }
        return content.length() > maxLength ? content.substring(0, maxLength) : content.toString();
    }


    private static Map<Character, Double> calculateCharacterFrequencies(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        int letterCount = 0;
        String lowerCaseText = text.toLowerCase();

        for (char c : lowerCaseText.toCharArray()) {
            if (RUSSIAN_ALPHABET.indexOf(c) != -1) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
                letterCount++;
            }
        }

        Map<Character, Double> frequencies = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            frequencies.put(entry.getKey(), (double) entry.getValue() / letterCount);
        }
        return frequencies;
    }



    public static String decrypt(String encryptedText, Map<Character, Double> referenceFrequencies) {
        Map<Character, Double> encryptedFrequencies = calculateCharacterFrequencies(encryptedText);
        int bestShift = 0;
        double minDifference = Double.MAX_VALUE;

        for (int shift = 0; shift < RUSSIAN_ALPHABET.length(); shift++) {
            double currentDifference = 0.0;
            for (Map.Entry<Character, Double> entry : encryptedFrequencies.entrySet()) {
                char encryptedChar = entry.getKey();
                int decryptedCharIndex = (RUSSIAN_ALPHABET.indexOf(encryptedChar) - shift + RUSSIAN_ALPHABET.length()) % RUSSIAN_ALPHABET.length();
                char decryptedChar = RUSSIAN_ALPHABET.charAt(decryptedCharIndex);

                currentDifference += Math.pow(entry.getValue() - referenceFrequencies.getOrDefault(decryptedChar, 0.0), 2);
            }

            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                bestShift = shift;
            }
        }

        return applyCaesarCipher(encryptedText, RUSSIAN_ALPHABET.length() - bestShift);
    }


    private static String applyCaesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        String lowerCaseText = text.toLowerCase();

        for (int i = 0; i < lowerCaseText.length(); i++) {
            char originalChar = text.charAt(i);
            char lowerChar = lowerCaseText.charAt(i);
            int index = RUSSIAN_ALPHABET.indexOf(lowerChar);

            if (index != -1) {
                int newIndex = (index + shift) % RUSSIAN_ALPHABET.length();
                char newChar = RUSSIAN_ALPHABET.charAt(newIndex);

                if (Character.isUpperCase(originalChar)) {
                    result.append(Character.toUpperCase(newChar));
                } else {
                    result.append(newChar);
                }
            } else {
                result.append(originalChar);
            }
        }
        return result.toString();
    }
}