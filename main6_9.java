import static java.lang.Math.*;
import java.util.Scanner;

public class main6_9 {
    public static void main(String[] args) {
        double a1 = 0.01; double a2 = 0.001; double a3 = 0.0001; double a4 = 0.00001; double a5 = 0.000001; int n = 0;
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double p = in.nextDouble();
        double y0 = exp(log(x*(p+1))/p)*0.9;
        m(a1, x, y0, p, n);
        m(a2, x, y0, p, n);
        m(a3, x, y0, p, n);
        m(a4, x, y0, p, n);
        m(a5, x, y0, p, n);
    }
    public static void m(double ep,double x,double y,double p,double n){
        double y_i = 1/p*((p - 1)*y+x/pow(y, p - 1));
        n++;
        if (abs(y_i - y) > ep) m(ep, x, y_i, p, n);
        else System.out.println(ep + ", " + (y_i) + ", " + n);
    }
}