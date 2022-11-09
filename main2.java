import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите a");
        double a = in.nextDouble();
        System.out.println("Введите b");
        double b = in.nextDouble();
        System.out.println("Введите c");
        double c = in.nextDouble();
        System.out.println("Введите d");
        double d = in.nextDouble();
        double m=0;
        if (a<0 & b<0 & c<0 & d<0){
            m = a*b*c*d;
        }else if(a<0 & b<0 & c<0){
            m = a*b*c;
        }else if(a<0 & b<0 & d<0){
            m = a*b*d;
        }else if(a<0 & c<0 & d<0){
            m = a*c*d;
        }else if(b<0 & c<0 & d<0){
            m = a*b*c;
        }else if(a<0 & b<0){
            m = a*b;
        }
        else if(a<0 & c<0){
            m = a*c;
        }
        else if(c<0 & b<0){
            m = c*b;
        }
        else if(b<0 & d<0){
            m = b*d;
        }
        else if(c<0 & d<0){
            m = c*d;
        }
        else if(a<0 & d<0){
            m = a*d;
        }
        else if(a<0){
            m = a;
        }
        else if( b<0){
            m = b;
        }
        else if(c<0){
            m = c;
        }
        else if(d<0){
            m = d;
        }
        if(m <0){
            System.out.println(m+" Число отрицательное");
        } else if( m == 0){
            System.out.println("Число равно "+m);
        }else {
            System.out.println(m+" Число положительное");
        }
    }
}
