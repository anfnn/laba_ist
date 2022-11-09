import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("введите число в диапозоне от -3 до 3 c шагом 0,5");
        double x = in.nextDouble();
        double f = 0;
        if (x>= -3 & x<=3){
            if (x<=1){
                f = x-2;
                System.out.println(" f = " +f);
            }else{
                f= Math.sin(x);
                System.out.println(" f = "+ f);
            }
        }else{
            System.out.println("Вы ввели не то число");
        }
    }
}
