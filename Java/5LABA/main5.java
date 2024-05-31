import java.util.Scanner;

public class main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x");
        double x = scanner.nextDouble();
        System.out.println("Введите y");
        double y = scanner.nextDouble();
        if ((x >= -3 & x<=2 & y >=-(2/3)*x-3 & y>= (7/2)*x-3 & y <=4 & y>=-3) || (x>-3 & x <=0 & y >=-(2/3)*x-3 & y<=x+2 & y<=1 & y>=-3) || (y<=x+2 & x>=-3 & x<=-1 & x >= -1*(Math.sqrt(4-Math.pow(y+3,2)))-1 & y<5 & y>=1) || (y <= Math.sqrt(4-Math.pow(x+1,2))+3 & x>=-3 & x<=-1& y<=-(1/2)*x+(5/2) & y<=5) || (x>=-2 & x<=2 & y <=4 & y<=-(1/2)*x+(5/2) & y<=2*x) &(x>=1 & x<=2 & y <=4 & y>=-3 & y<=2*x & y>=(7/2)*x -3)) {
            System.out.println("попал в 1 фигуру");
        } else if ((y >= - Math.sqrt(4-Math.pow(x-4,2))-1 & x>=2 & x<=7 & y>=-3 & y<=0 & y>= x-7) || (y >= - Math.sqrt(4-Math.pow(x-4,2))-1 & x>=2 & y>=-3 & y<=0 & x<=6 & y<=x-3)|| (y<=x-3 & y<=-x+3 & x>=2 & y <=1 & y >=-1 & x<=6)||(y<=-x+3 & x>=1 & x<=5 & y>=0 & y<=1 & y<=-((1)/(3))*x + (5/3))||(y<=-((1)/(3))*x + (5/3) & x>=2 & x<= 7 & y<=5 & y>=-1)||( y<=5 & y>=0 & x>=5 & x<=7 & y<=-((5)/(2))*x+((35)/(2)))||(y<=-((5)/(2))*x+((35)/(2)) & y<=5 & y>=-1 & x>=5 & x<=7 & y>=x-7 )){
            System.out.println("попал во 2 фигуру");
            } else{
            System.out.println("Не получилось(");
        }
        }
    }