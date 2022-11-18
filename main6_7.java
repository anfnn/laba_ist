public class main6_7 {
    public static void main(String[] args) {
        int[][] m;
        m = new int[9][9];
        int a;
        int b;
        int c ;
        for (a = 1; a<=9;a++){
            for (b =1; b<=9;b++) {
                c = a + b;
                System.out.print(a + "+" + b + "=" + c);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
