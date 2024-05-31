import java.util.Arrays;

public class main9_1 {
    public static void main(String[] args) {
        char[] array = {'a', 'B', 'c', 'D', 'e', 'F', 'g', 'H', 'i', 'J', 'k'};
        for (int i = 0; i < array.length; i++) {
            if (Character.isLowerCase(array[i])) {
                array[i] = Character.toUpperCase(array[i]);
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
