import java.util.Scanner;

public class main8_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("vvedite razmer");
        int N = in.nextInt();
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int g = 0; g < N; g++) {
                array[i][g] = N;
            }
        }
        int k=0;
        int s =1;
        int p = 0;
        for (int i = 1; i < N; i++) {
           for ( int j =N - i;j < N; j++){
                k = array[i][j];
                p = (int) Math.pow(k,s);
                s++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int g = 0; g < N; g++) {
                System.out.print( array[i][g]+"\t");

            }
            System.out.println();
        }
        System.out.println(p);

    }
}