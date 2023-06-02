import java.util.ArrayList;
import java.io.*;

public class main10_5 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("5_1.txt");
        ArrayList<String> predlojenia = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSent = line.split("[.!?]");
                for (String pred : lineSent) {
                    if (hasSymmetricWord(pred)) {
                        predlojenia.add(pred);
                    }
                }
            }
        }

        File outputFile = new File("5_2.txt");
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (String pred : predlojenia) {
                writer.println(pred);
            }
        }
    }

    private static boolean hasSymmetricWord(String pred) {
        String[] words = pred.toLowerCase().split("\\W+");
        for (String word : words) {
            if (isSymmetric(word)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSymmetric(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}