import java.util.Scanner;
public class main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите х");
        double x = in.nextDouble();
        double g;
        if (x >= -4 & x <= 4) {
            if (x <= 0) {
                g = (3 * x * x + Math.tan(2 * x + 3)) / (1 + 4 * x * x + Math.exp(1));
                System.out.println(g);
            } else {
                g = (2 * x + Math.pow(Math.cos(x), 3) - Math.pow(Math.sin(x), 2)) / (1 + x * x);
                System.out.println(g);
            }
        } else {
            System.out.println("Введен неправильный диапозон");
        }
    }
}

