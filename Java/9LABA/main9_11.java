import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main9_11 {

    public static void main(String[] args) {

        String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry"};

        // Регулярное выражение для замены первой буквы каждого слова на заглавную
        String regex1 = "(?<=\\s|^)[a-z]";
        Pattern pattern1 = Pattern.compile(regex1);

        // Регулярное выражение для удаления всех гласных букв
        String regex2 = "[aeiouAEIOU]";
        Pattern pattern2 = Pattern.compile(regex2);

        // Регулярное выражение для замены всех пробелов на дефисы
        String regex3 = "\\s+";
        Pattern pattern3 = Pattern.compile(regex3);

        for (int i = 0; i < stringArray.length; i++) {

            Matcher matcher1 = pattern1.matcher(stringArray[i]);
            StringBuffer sb = new StringBuffer();
            while (matcher1.find()) {
                matcher1.appendReplacement(sb, matcher1.group().toUpperCase());
            }
            matcher1.appendTail(sb);
            String formattedString = sb.toString();

            formattedString = formattedString.replaceAll(regex2, "");

            formattedString = formattedString.replaceAll(regex3, "-");

            stringArray[i] = formattedString;
        }

        System.out.println(Arrays.toString(stringArray));
    }

}