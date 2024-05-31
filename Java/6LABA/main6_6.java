import static java.lang.Math.*;
import java.util.Scanner;

public class main6_6 {
    public static class Oblast {
        public static boolean Vichislenie(double x, double y) {
            return (x <= Math.sqrt(36 - y * y) & x >= 0) &&(((Math.pow(x - 4, 2) + Math.pow(y, 2) > 1 && Math.pow(x - 4, 2) + Math.pow(y, 2) < 4) || (y < 4 && y > 1 && y > x + 1 && x < 3) || (y > x + 1 && y > (-4 / 3) * x + 1 && y < 4 && y > -3 && x > 0 && x < 3) || (y < 1 && y > -4 && x > 0 && x < 3 && y > (-4 / 3) * x + 1 && y > (1 / 3) * x - 4)));
        }
    }

    public static boolean getAns() {
        System.out.println("хотите проверить 1 - да , 2 - нет");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        return ans == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ans = getAns();
        while (ans) {
            System.out.println("введите x и y");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            System.out.println(Oblast.Vichislenie(x, y));
            ans = getAns();
        }
    }
}