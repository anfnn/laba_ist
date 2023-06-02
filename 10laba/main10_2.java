import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
public class main10_2 {
    public static void main(String[] args) throws IOException{
        File file = new File("10_2.txt");
        FileWriter FW = new FileWriter(file);
        int a;
        int b;
        int c ;
        for (a = 1; a<=9;a++) {
            for ( b = 1; b <= 9; b++) {
                c = a + b;
                FW.write(a + " + " + b + " = " + c + "\t");
            }
            FW.write("\n");
        }
        FW.close();
    }
}
