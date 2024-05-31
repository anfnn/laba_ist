import java.io.*;
import java.util.ArrayList;

public class main10_3 {
    public static void main(String[] args) throws IOException {
        File file = new File("10_3.txt");
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = BR.readLine()) != null) {
                String[] lineWords = line.split(" ");
                for (String word : lineWords) {
                    if (word.matches(".*\\d.*")) {
                        words.add(word);
                    }


                }
            }
            for (String word : words) {
                System.out.println(word);
            }
        }
    }}