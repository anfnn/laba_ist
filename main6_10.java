import static java.lang.Math.*;
import java.util.Scanner;

public class main6_10 {
    public static void main(String[] args) {
        double h;
        double sum;
        double n;
        for (n = 10; n <= 10000; n *= 10) {
            h = 1 / n;
            sum = 0;
            for (int i = 1; i < n; i++) {
                sum += (8 * Math.pow(n - h * (i-1), 5) - Math.sin(n - h * (i - 1))) * h;
            }
            System.out.println("n " + n + " h " + h + " sum " + sum );

        }
    }
}