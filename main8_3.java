import java.util.Scanner;

public class main8_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] coordn = new double[2*n];
        for (int i = 0; i < 2*n; i++) {
            coordn[i] = scanner.nextDouble();
        }
        double xc1 = scanner.nextDouble();
        double yc1 = scanner.nextDouble();
        double r1 = scanner.nextDouble();
        double xc2 = scanner.nextDouble();
        double yc2 = scanner.nextDouble();
        double r2 = scanner.nextDouble();
        double innerRadius = r2 - r1;
        double outerRadius = r2;
        for (int i = 0; i < 2*n; i += 2) {
            double x = coordn[i];
            double y = coordn[i+1];
            double d1 = Math.sqrt(Math.pow(x-xc1, 2) + Math.pow(y-yc1, 2));
            double d2 = Math.sqrt(Math.pow(x-xc2, 2) + Math.pow(y-yc2, 2));
            if (d1 < innerRadius && d2 > outerRadius) {
                System.out.println("Точка " + (i/2 + 1) + " лежит вне кольца");
            } else{
                System.out.println("OSHIBKA HAHA");
            }
        }
    }
}