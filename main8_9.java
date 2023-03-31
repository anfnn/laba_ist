import java.util.Scanner;
public class main8_9 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность квадратной матрицы");
        int N = in.nextInt();
        int A[][] = new int[2*N][2*N];
        Zmeika2(A,N,0,0);
        Zmeika(A,N,0,N);
        Zmeika(A,N,N,0);
        Zmeika2(A,N,N,N);
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
            for(int i = N-1-k; i >= 2*k; i--){
                A[i+movei][(N-1)+k-i+movej] = sch++;
            }
            for(int i = 1+2*k; i <= N-1-k;i++){
                A[i+ movei][N-1-k + movej] = sch++;
            }
            for(int i = N-2-k; i >= 1+2*k;i--){
                A[N-1-k + movei][i+ movej] = sch++;
            }

            k++;
        }
        return A;
    }
    public static int [][] Zmeika2(int[][]A,int N, int movei, int movej){
        int k = 0, sch = 1;
        while(k<= Math.ceil(N/2)){
            for(int i = 2*k; i <=N-1-k; i++) {
                A[ k+ movei ][i + movej ] = sch++;
            }
            for(int i = k+1; i <=N-1-2*k; i++) {
                A[ i + movei][N-1-k + movej] = sch++;
            }
            for( int i = N-2-k ; i > 2*k; i--){
                A[i -k+ movei][i+ movej]= sch++;

            }

            k++;
        }
        return A;
    }
}