import java.lang.Character;
import java.util.ArrayList;
import java.util.Scanner;

public class main9_4 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(" Введите размерность матрицы N");
        int n = in.nextInt();
        char [][] matrix = new char [n][n];
        for ( int i = 0; i < n ; i++){
            for ( int j = 0; j< n; j++){
                matrix[i][j] = Simvol();
            }
        }
        ArrayList<String> incorrectExpressions = new ArrayList<>();

        // проверка по строкам
        for (int i = 0; i < n; i++) {
            String expression = "";
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '2' || matrix[i][j] == '3') {
                    int num1 = Character.getNumericValue(matrix[i][j + 1]);
                    int num2 = Character.getNumericValue(matrix[i][j + 3]);
                    int num3 = Character.getNumericValue(matrix[i][j + 5]);
                    int expected = (matrix[i][j] == '2') ? ((num1 + num2) / num3) : (3 * (num1 + num2) / num3);
                    int result = Character.getNumericValue(matrix[i][j + 7]);
                    if (result != expected) {
                        incorrectExpressions.add(expression);
                    }
                }
                expression += matrix[i][j];
            }
        }

        // проверка по столбцам
        for (int j = 0; j < n; j++) {
            String expression = "";
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '2' || matrix[i][j] == '3') {
                    int num1 = Character.getNumericValue(matrix[i + 1][j]);
                    int num2 = Character.getNumericValue(matrix[i + 3][j]);
                    int num3 = Character.getNumericValue(matrix[i + 5][j]);
                    int expected = (matrix[i][j] == '2') ? ((num1 + num2) / num3) : (3 * (num1 + num2) / num3);
                    int result = Character.getNumericValue(matrix[i + 7][j]);
                    if (result != expected) {
                        incorrectExpressions.add(expression);
                    }
                }
                expression += matrix[i][j];
            }
        }

        // вывод информации
        System.out.println("Количество правильно вычисленных выражений: " + ((n - 2) * 2));
        System.out.println("Количество неправильно вычисленных выражений: " + incorrectExpressions.size());
        System.out.println("Список неправильных выражений:");
        for (String expression : incorrectExpressions) {
            System.out.println(expression);
        }
    }

    private static char Simvol() {
        char ch = ' ';
        String S = in.next();
        if ( S.length() == 1) {
            ch = S.charAt(0);
        } else {
            while (S.length()!=1){
                System.out.println("Повторите еще раз");
                S = in.next();
                if(S.length() == 1){
                    ch = S.charAt(0);
                }
            }
        }
        return ch;
    }
}
