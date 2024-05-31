import java.util.ArrayList;
import java.io.*;

public class main10_4 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("4_1.txt");
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("[_.,;:\\n\\t!?]");
                for (String word : lineWords) {
                    if (isBalanced(word)) {
                        words.add(word);
                    }
                }
            }
        }

        File outputFile = new File("4_2.txt");
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (String word : words) {
                writer.println(word);
            }
        }
    }

    public static boolean isBalanced(String word) {
        int numglas = 0;
        int numsoglas = 0;
        for (char c : word.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                numglas++;
            } else if (Character.isLetter(c)) {
                numsoglas++;
            }
        }
        return numglas == numsoglas;
    }
}