import java.util.Scanner;

public class main6_3_2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long Pr = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                Pr *= j;
            }
        }
        System.out.println("Произведение произведений равно " + Pr);
    }
}


