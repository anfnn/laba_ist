import java.util.Scanner;

public class main9_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] numberChars = new char[0];
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введите число в десятичной системе счисления:");
            String numberString = scanner.nextLine();

            // Проверяем, что все символы являются цифрами от 0 до 9
            if (numberString.matches("[0-9]+")) {
                numberChars = numberString.toCharArray();
                validInput = true;
            } else {
                System.out.println("Число введено неверно. Попробуйте ещё раз.");
            }
        }

        // Преобразуем число в двоичную систему счисления
        StringBuilder binaryStringBuilder = new StringBuilder();
        int decimalNumber = Integer.parseInt(new String(numberChars));
        while (decimalNumber > 0) {
            binaryStringBuilder.append(decimalNumber % 2);
            decimalNumber /= 2;
        }
        binaryStringBuilder.reverse(); // переворачиваем строку

        // Записываем двоичное число в массив символов
        char[] binaryChars = binaryStringBuilder.toString().toCharArray();

        // Выводим результат
        System.out.println("Двоичное представление числа: " + new String(binaryChars));
    }
}