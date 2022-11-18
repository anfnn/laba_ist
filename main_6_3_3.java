public class main_6_3_3 {
    public static void main(String[] args) {
        long Sss = 0;
        int j;
        int i;
        int k ;
        for ( i = 1; i<=8;i++){
            for (j=1 ; j<=i; j++){
                for (k=1;k<=(i+j);k++){
                    Sss += (j*j+i+k);

                }
            }
        }
        System.out.println("Сумма сумм сумм  " + Sss);

    }
}
