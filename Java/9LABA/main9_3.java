import java.util.Scanner;
import java.util.Stack;

public class main9_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();

        // а)
        int digitsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digitsCount++;
            }
        }
        System.out.println("Количество цифр: " + digitsCount);

        // б)
        System.out.println("Введите символ для поиска:");
        char searchChar = scanner.next().charAt(0);
        findAndCount(arr, searchChar);

        // в)
        System.out.println("Введите цифры для проверки (без пробелов):");
        String digitsInput = scanner.next();
        boolean vsechisla = vsechisla(arr, digitsInput);
        System.out.println("Содержит все цифры: " + vsechisla);

        // г)
        boolean zakrskobki = proverkask(arr);
        if (zakrskobki) {
            System.out.println("В последовательности есть закрытые пары скобок");
        } else {
            System.out.println("В последовательности нет закрытых пар скобок");
        }

        // д)
        boolean znakiprep = znakiprep(arr);
        if (znakiprep) {
            System.out.println("В последовательности есть пара соседствующих знаков препинания");
        } else {
            System.out.println("В последовательности нет пары соседствующих знаков препинания");
        }

        // е)
        boolean chislposl = chislposl(arr);
        if (chislposl) {
            System.out.println("В последовательности есть подходящая числовая последовательность");
        } else {
            System.out.println("В последовательности нет подходящей числовой последовательности");
        }
    }


    static void findAndCount(char[] arr, char c) {
        int count = 0;
        boolean found = false;
        for (char ch : arr) {
            if (ch == c) {
                count++;
                found = true;
            }
        }
        if (found) {
            System.out.println("Символ " + c + " найден " + count + " раз");
        } else {
            System.out.println("Символ " + c + " не найден");
        }
    }

    static boolean vsechisla (char[] arr, String digits) {
        for (int i = 0; i < digits.length(); i++) {
            if (!new String(arr).contains(digits.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }

    static boolean proverkask(char[] arr) {
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && c != ')') || (top == '[' && c != ']') || (top == '{' && c != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean znakiprep(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (Character.getType(arr[i]) == Character.getType(arr[i - 1])
                    && Character.getType(arr[i]) == Character.CONNECTOR_PUNCTUATION) {
                return true;
            }
        }
        return false;
    }

    static boolean chislposl(char[] arr) {
        for (int i = 0; i < arr.length - 3; i++) {
            if (Character.isDigit(arr[i]) && Character.isDigit(arr[i + 1])
                    && Character.isDigit(arr[i + 2]) && Character.isDigit(arr[i + 3])) {
                if (arr[i] < arr[i + 1] && arr[i + 1] < arr[i + 2] && arr[i + 2] > arr[i + 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}