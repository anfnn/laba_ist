import java.util.Scanner;

public class main6_8 {
    public static class FunctionMy {
        public static double funct1(double y) {
            final double p = 1;
            return (Math.pow(Math.sin(p + 0.4), 2) / (y * y + 7.325 * p));
        }

        public static double funct2(double y) {
            final double a = 0, x = 0, c = 1;
            return ((Math.pow(a, 5) + Math.acos(a + Math.pow(x, 3)) - Math.pow(Math.sin(y - c), 4))) / (Math.pow(Math.sin(x + y), 3) + Math.abs(x - y));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        double sum = 0;
        double m = 0;
        while (m<10){
            System.out.println("Vvedite y");
            double y = in.nextDouble();
            sum += FunctionMy.funct1(y) + FunctionMy.funct2(y);
            m++;
        }
        System.out.println("Итоговая сумма 2 функций равна " + sum);
    }
}