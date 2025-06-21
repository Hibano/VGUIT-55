import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatting {

    public static String transformText(String text) {
        Pattern pattern = Pattern.compile("([а-яА-Яa-zA-Z]+)");
        Matcher matcher = pattern.matcher(text);

        StringBuilder transformedText = new StringBuilder();
        int lastIndex = 0;

        while (matcher.find()) {
            // Добавляем часть текста до найденного слова
            transformedText.append(text.substring(lastIndex, matcher.start()));

            String word = matcher.group(1);
            if (word.length() > 0) {
                // Перемещаем первую букву в конец и добавляем "ауч"
                transformedText.append(word.substring(1)).append(word.charAt(0)).append("ауч");
            } else {
                transformedText.append(word);
            }
            lastIndex = matcher.end();
        }
        transformedText.append(text.substring(lastIndex));

        return transformedText.toString();
    }

    public static void main(String[] args) {
        String inputText1 = "Также как высокое качество позиционных исследований выявляет срочную потребность поставленных обществом задач.";
        String transformedText1 = transformText(inputText1);
        System.out.println("Исходный текст: " + inputText1);
        System.out.println("Преобразованный текст: " + transformedText1);
    }
}