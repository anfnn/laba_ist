import java.util.Scanner;

public class main7_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите х");
        double x = in.nextDouble();
        double z;
        if (x >= -4 & x <= 4) {
            if (x < 0) {
                z = (3 * x + Math.pow(Math.exp(1) + x * x, 1 / 4)) / (2 * Math.abs(x - 2));
                System.out.println(z);
            } else if (x >= 0 & x <= 1) {
                z = 2 * Math.cos(x) * Math.pow(Math.exp(1), -2 * x) + 2 * Math.PI * x;
                System.out.println(z);
            } else if (x > 1) {
                z = 2 * Math.sin(3 * x) - Math.tan(Math.pow(x, 3) - Math.pow(x, 2));
                System.out.println(z);
            }
        } else {
                System.out.println("Введен неправильный диапозон");
            }
        }
    }
