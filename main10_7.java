import java.io.*;

public class main10_7 {
        public static void main(String[] args) throws IOException{

            FileWriter writer = new FileWriter("10_7.txt");
            writer.write("Диапазон аргумента:-3<=x<=3\n"+
                    "Функция:if (x <=1 ) -> f(x) = x-2\n"+
                    "else f(x) =sin(x)\n" +
                    "Вывод в порядке возрастания x\n");
            for (Double x = -3.0; x <= 3.0; x += 0.5) {
                if (x <=1) {
                   writer.write(("x=" + x + "; f(x)=" + (x- 2) + "\n"));
                } else writer.write(("x=" + x + "; f(x)=" + Math.sin(x) + "\n"));
            }
            writer.close();
        }
    }
