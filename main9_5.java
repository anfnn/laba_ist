import java.util.*;

public class main9_5 {
    public static void main(String[] args) {
        String text = "Java is a programming language that is class-based and object-oriented.";
        String[] words = text.toLowerCase().split(" ");

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                int count = wordCounts.get(word);
                wordCounts.put(word, count + 1);
            }
        }

        String oddWord = null;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWord = entry.getKey();
                break;
            }
        }

        System.out.println(" нечетное слово: " + oddWord);
    }
}