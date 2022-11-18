import java.util.Scanner;

public class main6_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("vvedite chislo");
        double number = in.nextDouble();
        if (number >= 1 || number <0) {
            System.out.println("Oshibka");
            System.exit(0);
        }
            boolean otv = datotvet();
            while (otv) {
                double otvet = Double.parseDouble(basa(number));
                System.out.println(otvet);
                otv = datotvet();
            }
        }
    public static String basa(double number) {
        Scanner in = new Scanner(System.in);
        System.out.println("vvedite sistemu schislenija");
        int base = in.nextInt();
        if (base < 2 || base >= 11 || number < 0) {
            System.out.println("Oshibka");
            System.exit(0);
        }
        int k = -1;
        double x=1,ans=0,bv=0;
        while (number % 2 != 0 && Math.abs(k) < 10) {
            number *= base;
            bv = (number - (number % 1));
            ans += bv * Math.pow(10, k);
            number -= bv;
            k--;
        }
        
        return String.valueOf((ans));
    }
    public static boolean datotvet() {
        System.out.println("hotite prodolshit true/false");
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }
}

