import java.util.Scanner;

public class  main8_6{
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Vvedite dlinu massiva" );
        int size = in.nextInt();
        int array [] = new int[size];
        for ( int i = 0 ; i < size; i++){
            System.out.println("Vverdite " + i + " element massiva");
            array[i] = in.nextInt();
        }
        int [][]array2 = new int[size][size];
        for ( int i = 0 ; i < size; i++){
            for ( int g = 0; g< size; g++){
                array2[i][g] = (int)Math.pow(array[g],i);
            }
        }
        for ( int i = 0 ; i< array2.length; i++){
            for ( int g = 0; g < array2.length; g++){
                System.out.print( array2[i][g] +"\t");
            }
            System.out.println();
        }


    }

}