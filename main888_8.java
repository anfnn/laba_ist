import java.util.Scanner;
public class main888_8 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность квадратной матрицы");
        int N = in.nextInt();
        if ( N%2 == 1){
            N = N+1;
        }
        int A[][] = new int[N][N];

        Zmeika(A,N,0,0);
        Zmeika(A,N,0,N/2);
        Zmeika(A,N,N/2,0);
        Zmeika(A,N,N/2,N/2);
        printMas(A);
    }
    public static void printMas(int array[][]){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static int [][] Zmeika(int[][]A,int N, int movei, int movej){
        int k = 0, sch = 1;
        while(k<= Math.ceil(N/2)){
            for(int i = N/2-1-k; i >= 2*k; i--){
                A[i+movei][(N/2-1)+k-i+movej] = sch++;
            }
            for(int i = 1+2*k; i <= N/2-1-k;i++){
                A[i+ movei][N/2-1-k + movej] = sch++;
            }
            for(int i = N/2-2-k; i >= 1+2*k;i--){
                A[N/2-1-k + movei][i+ movej] = sch++;
            }

            k++;
        }
        return A;
    }
}