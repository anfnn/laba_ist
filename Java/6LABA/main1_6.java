import java.util.Scanner;

public class main1_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vvedite n");
        double n = in.nextDouble();
        System.out.println("Vvedite x");
        double x = in.nextDouble();
        System.out.println("Vvedite m");
        double m = in.nextDouble();
        double Sn = (n+1)*Math.pow(x,0);
        double y = 0;
        double k = 0;
        while (Sn < m){
            y = y+Sn;
            k = k+n;
            n++;
            Sn = (n+1)*Math.pow(x,0);
        }
        System.out.println("Сумма первых n членов равна " + k);
        System.out.println("Сумма членов ряда равна " + y);
    }
}
