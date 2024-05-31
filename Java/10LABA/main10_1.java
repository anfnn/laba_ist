import java.util.*;
import java.io.*;

public class main10_1 {
    public static char vvod() {
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();
        char t;
        while (true) {
            if (x.length() != 1) {
                System.out.println("Элемент массива должен быть одним символом");
                x = input.nextLine();
            } else {
                t = x.charAt(0);
                break;
            }
        }
        return t;
    }

    public static String vvodstr() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void mas(char[] arr) {
        try (FileReader reader = new FileReader("10_1.txt")) {
            int c;
            while ((c = reader.read(arr)) > 0) {

                if (c < 10) {
                    arr = Arrays.copyOf(arr, c);
                }
                System.out.println(arr);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static int a(char[] arr) {
        int digitsCount = 0;
        for (Character character : arr) {
            if (String.valueOf(character).matches("[0-9]")) {
                digitsCount++;
            }
        }
        return ( digitsCount);
    }

        public static int b(char[] arr, char s){
            int countb = 0;
            for (Character character : arr) {
                if (character == s) {
                    countb += 1;
                }
            }
            return countb;
        }

        public static boolean c ( char[] arr, String inputNumber){
            int count = 0;
            for (char ch : arr) {
                if (Character.isDigit(ch) && inputNumber.contains(String.valueOf(ch))) {
                    count++;
                    if (count >= 2) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean d ( char[] arr){
            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] == '(' && arr[i + 1] == ')') || (arr[i] == '{' && arr[i + 1] == '}') || (arr[i] == '[' && arr[i + 1] == ']')) {
                    return true;
                }
            }
            return false;
        }


        public static boolean e ( char[] arr){
            for (int i = 1; i < arr.length; i++) {
                if (Character.getType(arr[i]) == Character.getType(arr[i-1]) && Character.getType(arr[i]) == Character.CONNECTOR_PUNCTUATION){
                    return true;
                }
            }
            return false;
        }

        public static boolean f ( char[] arr){
            for (int i = 0; i < arr.length - 3; i++) {
                if (Character.isDigit(arr[i]) &&
                        Character.isDigit(arr[i + 1]) &&
                        Character.isDigit(arr[i + 2])) {
                    int num1 = arr[i];
                    int num2 = arr[i + 1];
                    int num3 = arr[i + 2];
                    if (num1 > num2 && num2 > num3) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static void main (String[]args) throws IOException {
            Scanner input = new Scanner(System.in);
            System.out.println("Введите длинну массива");
            int len = input.nextInt();
            char[] arr = new char[len];
            mas(arr);
            System.out.println("Введите символ для поиска в пункте б");
            char b = vvod();
            System.out.println("Введите число для поиска в пункте в");
            String c = vvodstr();
            FileWriter writer = new FileWriter("10_1.txt", true);
            PrintWriter printer = new PrintWriter(writer);
            printer.println("\nРезультаты обработки массива:");

            printer.printf("а) Кол-во цифр %d\n", a(arr));
            printer.println("б) Введенный символ входит в последовательность " + b(arr, b) + " раз");

            if (c(arr, c)) {
                printer.println("в) Среди символов есть 2 или более цифры, входящие в число " + c);
            } else {
                printer.println("в) Среди символов нет 2 или более цифр, входящих в введённое вами число, или вы ввели не число");
            }

            if (d(arr)) {
                printer.println("г) Последовательность содержит пару соседствующих закрытых скобок");
            } else {
                printer.println("г) Последовательность не содержит пару соседствующих закрытых скобок");
            }

            if (e(arr)) {
                printer.println("д) В последовательности есть пара соседстсвующих знака препинания");
            } else {
                printer.println("д) В последовательности нет пары соседствующих знака препинания");
            }

            if (f(arr)) {
                printer.println("е) Существуют такие натуральные i и j, что i<k<j<n и " +
                        "si, и si+1 убывающая последовательность цифр, a sj и sj+1 возрастающая последовательность чисел");
            } else {
                printer.println("е) Не существуют такие натуральные i и j, что i<k<j<n и " +
                        "si, и si+1 убывающая последовательность цифр, a sj и sj+1 возрастающая последовательность чисел");
            }
            printer.flush();
            printer.close();
        }
    }