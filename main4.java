import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("введите число в диапозоне от -3 до 3 ");
        double x = in.nextDouble();
        double y = 0;
        if (x < -3) {
            y = Math.sin(x * x - 2 * x);
        } else if (x > -3 & x < 0) {
            y = Math.exp(x) - 1;
        } else if (x > 0) {
            y = (4 + x) / (Math.pow(x, 2) - 1);
        } else if ((x == -3) ||( x == 0)) {
            y = 10;
        }
        System.out.println("y равняется" + y);
    }
}