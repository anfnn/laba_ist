import java.util.Scanner;

import static java.lang.System.exit;

public class main9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Где ты учишься ?"+"1)ПНИПУ"+" 2)ПГНИУ");
        int ans1 = in.nextInt();
        if(in.hasNextLine())
            switch(ans1) {
                case 1->
                    System.out.println("Молодец!");
                case 2-> {
                    System.out.println("Ну такое");
                    exit(0);
                }
            }

        System.out.println("Какой автобус едет до политеха" +
                "1) 41"+
                " 2) 53"+
                " 3) 20");
        int ans2 = in.nextInt();
        if (in.hasNextLine())
            switch (ans2){
                case 1-> System.out.println("Так держать!");
                case 2 -> System.out.println("Неплохо");
                case 3->System.out.println("Можно было и получше");
        }
        System.out.println("Сколько рублей составляет академическая стипендия?"+
                "1)2600"+
                " 2)2620"+
                " 3)5940");
        int ans3 = in.nextInt();
        if (in.hasNextLine())
            switch(ans3){
                case 1-> System.out.println("ЦЕЛЫХ 20 РУБЛЕЙ УПУСТИЛ");
                case 2-> System.out.println("Молодец какой!!");
                case 3-> System.out.println("Если бы...");
            }
        System.out.println("Как начинается гимн ФПММ?"+
                "1) Учитесь лучше все на ФПММ"+
                " 2)ФПММ - самый крутой"+
                " 3) ФПММ - лучше всех");
        int ans4 = in.nextInt();
        if(in.hasNextLine())
            switch(ans4){
                case 1-> System.out.println("УЧИТЕСЬ ВСЕ НА ФПММ");
                case 2-> System.out.println("Жаль, но неправильно");
                case 3-> System.out.println("Неплохо, но не то(");
            }
        System.out.println("Поздравляю с прохождением теста, теперь ты настоящий политехник!");
    }
}