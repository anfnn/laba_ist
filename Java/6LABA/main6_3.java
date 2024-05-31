public class main6_3 {
    public static void main(String[] args) {
        double i;
        double j;
        double Sj =  0;
        double Si = 0;
        for ( i = 1;i<=8;i++){
            j = 1;
            while (j<=i){
                Sj = Sj + (i+j)*(i-j);
                j++;

            }
            Si = Si+Sj;
            Sj = 0;
    }
        System.out.println("Сумма сумм равна = "+ Si);
}
}
