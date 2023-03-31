import java.util.Scanner;

public class main8_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vvedite razmer");
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
            if (array[i] < 0 || array[i] > 1) {
                System.out.println("Nepravilno");
                System.exit(0);
            }
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int K = size - i - 1;
            int num_k = array[K];
            sum += num_k * Math.pow(2, i);
        }
        int c =0;
        int t = sum;
        while ( t >0){
            int k  = t%10;
            t = t/10;
            c = c+1;
        }
        int[] array2 = new int[c];
        int y = 0;
        while ( sum%10 >0){
            int r = y;
            int l = (int) (sum / Math.pow(10,c-1));
            array2[r] = l;
            sum = (int) (sum % Math.pow(10,c-1));
            c = c-1;
            y+=1;
            System.out.print(array2[r]);
            System.out.print(" ");
        }

        }
    }



