import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую сторону треугольника");
        double x = in.nextInt();
        System.out.println("Введите вторую сторону треугольника");
        double y = in.nextInt();
        System.out.println("Введите третью сторону треугольника");
        double z = in.nextInt();
        double a = (Math.pow(x,2)+ Math.pow(y,2) - Math.pow(z,2))/2*x*y;
        double b = (Math.pow(z,2)+ Math.pow(x,2) - Math.pow(y,2))/2*x*z;
        double c = (Math.pow(y,2)+ Math.pow(z,2) - Math.pow(x,2))/2*z*y;

        if ((x * x == y * y + z * z) || (y * y == x * x + z * z) || (z * z == y * y + x * x)) {
            System.out.println("треугольник прямоугольный");
        }else{
            System.out.println("1 "+Math.toDegrees(Math.acos(Math.cos(a)))+"2 "+Math.toDegrees(Math.acos(Math.cos(b)))+"3 "+Math.toDegrees(Math.acos(Math.cos(c))));
        }
    }
}

