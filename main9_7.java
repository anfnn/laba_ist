import java.util.Scanner;

public class main9_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        String str = in.nextLine();

        StringBuilder result = new StringBuilder();

        String[] words = str.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }
}