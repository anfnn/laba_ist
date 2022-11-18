import java.util.Scanner;

public class main6_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vvedite m");
        double m = in.nextDouble();;
        double a = 1;
        double b = 1;
        double c;
        double i = 0;
        System.out.println("Числа Фибоначчи");
        while (i<m){
            c = a+b;
            b = a;
            a = c;
            i++;
            System.out.println(c);
        }
    }
}