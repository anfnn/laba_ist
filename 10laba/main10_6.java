import java.io.*;

public class main10_6 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("6_1.txt");
        File outputFile = new File("6_2.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String brand = parts[0];
            double mass = Double.parseDouble(parts[1]);
            int year = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);

            if (mass >= 2 && mass <= 5 && year >= 2000 && year <= 2007) {
                count++;
            }

            writer.write(line + "\n");
        }

        writer.write("Количество автомобилей с массой от 2 до 5 тонн и годом выпуска от 2000 до 2007: " + count);

        reader.close();
        writer.close();
    }
}