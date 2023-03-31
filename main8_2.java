import java.util.Scanner;

public class main8_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер");
        int size = in.nextInt();
        int array[] = new int[size];
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = in.nextInt();
        }
        int k = 0;
        for (int i = 0; i < size - 1; i++) {
            if (array[i+1] < array[i]){
                System.out.println(i+1+"uchastok = "+ array[i]+""+ array[i+1]);
            }
            k++;
        }
        int r = k;
        System.out.println("kolichestvo uchastkov " + r);
    }

}