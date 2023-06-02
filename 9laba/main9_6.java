import java.util.Scanner;

public class main9_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число семей: ");
        int familiesCount = scanner.nextInt();
        String[][] familyData = new String[familiesCount][11];

        for (int i = 0; i < familiesCount; i++) {
            System.out.println("Введите данные для " + (i + 1) + "-й семьи:");
            System.out.print("Фамилия: ");
            familyData[i][0] = scanner.next();
            System.out.print("Район: ");
            familyData[i][1] = scanner.next();
            System.out.print("Полная/Неполная семья: ");
            familyData[i][2] = scanner.next();
            System.out.print("Количество членов семьи: ");
            familyData[i][3] = scanner.next();
            System.out.print("Количество детей: ");
            familyData[i][4] = scanner.next();
            System.out.print("Количество комнат в жилье: ");
            familyData[i][5] = scanner.next();
            System.out.print("Квадратные метры жилья: ");
            familyData[i][6] = scanner.next();
            System.out.print("Доход на одного члена семьи: ");
            familyData[i][7] = scanner.next();
            System.out.print("Наличие компьютеров: ");
            familyData[i][8] = scanner.next();
            System.out.print("Количество компьютеров: ");
            familyData[i][9] = scanner.next();
            System.out.print("Наличие домашних животных: ");
            familyData[i][10] = scanner.next();
            System.out.println();
        }

        // Далее можно обработать данные в массиве familyData
    }
}