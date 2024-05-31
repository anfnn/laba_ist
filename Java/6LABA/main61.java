import java.util.Scanner;

public class main61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vvedite x");
        double x = in.nextDouble();
        System.out.println("Vveditr y");
        double y = in.nextDouble();
        if (x <= Math.sqrt(36 - y * y) & x >= 0) {
            if ((Math.pow(x - 4, 2) + Math.pow(y, 2) > 1 & Math.pow(x - 4, 2) + Math.pow(y, 2) < 4) || (y < 4 & y > 1 & y > x + 1 & x < 3) || (y > x + 1 & y > (-4 / 3) * x + 1 & y < 4 & y > -3 & x > 0 & x < 3) || (y < 1 & y > -4 & x > 0 & x < 3 & y > (-4 / 3) * x + 1 & y > (1 / 3) * x - 4)) {
                System.out.println("ne popali");
            } else {
                System.out.println("popali");
            }
        } else {
            System.out.println("ne popali");
        }
    }
}