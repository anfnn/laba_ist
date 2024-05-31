import java.util.Scanner;

public class main6_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(TextCompressor.compress(text));
    }
    public class TextCompressor {
        public static String compress(String text) {
            StringBuilder compressedText = new StringBuilder();
            int i = 0;

            while (i < text.length()) {
                char c = text.charAt(i);
                int count = 1;

                while (i + 1 < text.length() && text.charAt(i + 1) == c) {
                    count++;
                    i++;
                }

                if (count > 1) {
                    compressedText.append(c).append(count);
                } else {
                    compressedText.append(c);
                }

                i++;
            }

            return compressedText.toString();
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            System.out.println(compress(text));
        }}}

