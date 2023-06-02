import java.util.regex.*;

public class main9_12 {
    public static void main(String[] args) {
        String[] strings = {"жылу  медведь", "мальчик шыл", "онннна пошла гулять", "собака бежала     к    кошке"};

        Pattern pattern1 = Pattern.compile("жы");
        Pattern pattern2 = Pattern.compile("шы");
        Pattern pattern3 = Pattern.compile("(\\w)\\1{2,}");
        Pattern pattern4 = Pattern.compile("\\s{2,}");

        for (String string : strings) {
            String isprav = string;
            isprav = pattern1.matcher(isprav).replaceAll("жи");
            isprav = pattern2.matcher(isprav).replaceAll("ши");
            isprav = pattern3.matcher(isprav).replaceAll("$1$1");
            isprav = pattern4.matcher(isprav).replaceAll(" ");

            System.out.println(string);
            System.out.println(isprav);
        }
    }
}