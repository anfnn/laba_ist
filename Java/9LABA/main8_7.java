import java.util.Scanner;
public class main8_7 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Размерность матрицы");
        int N = scn.nextInt();
        int[][] mas2 = new int[N][N];
        Zmey(mas2,N);
        printMas2(mas2);
    }

    public static int[][] Zmey(int[][] mas2, int N) {
        int k = 0;
        int sch = 1;
        while ( k <= Math.ceil(N/2)){
            for (int i = k; i < N - 1-k; i++) {
                mas2[i][k] = sch++;
            }
            for (int i = k; i <= N - 1-k; i++) {
                mas2[N-1-k][i] = sch++;
            }
            for (int i = N-2-k; i >= k; i--) {
                mas2[i][N-1-k] = sch++;
            }
            for (int i = N-2-k ; i > k; i--) {
                mas2[k][i] = sch++;
            }
            k=k+1;
        }
        return mas2;
    }
    public static void printMas2(int[][] array) {
        for (int i=0; i<=array.length-1; i++) {
            for (int j=0; j<=array[0].length-1; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}