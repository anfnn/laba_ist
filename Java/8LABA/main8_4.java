import java.util.Scanner;

public class main8_4 {
public static void selectionSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
        int pos = i;
        int min = sortArr[i];
        for (int j = i + 1; j < sortArr.length; j++) {
        if (sortArr[j] < min) {
        pos = j;
        min = sortArr[j];
        }
        }
        sortArr[pos] = sortArr[i];
        sortArr[i] = min;
        }
        }

public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] sortArr = new int[N];
    for (int i = 0; i <= sortArr.length - 1; i++){
        sortArr[i] = in.nextInt();
}
    selectionSort(sortArr);
    for(int i = 0; i < sortArr.length; i++){
        System.out.print(sortArr[i] + "\n");
    }
}
}