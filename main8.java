import java.util.Scanner;

public class main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите день недели");
        String name = in.nextLine();
        switch (name) {
            case "Понедельник":
                System.out.println("Сырники из г корпуса с палпи");
                break;
            case "Вторник":
                System.out.println("Карман с кофе 3 в 1");
                break;
            case "Среда":
                System.out.println("Шницель с макаронами и с компотиком");
                break;
            case "Четверг":
                System.out.println("Салатик Оливье и греча");
                break;
            case "Пятница":
                System.out.println("Котлетки с пюрешкой");
                break;
            case "Суббота":
                System.out.println("Стейк с кровью и компотом");
                break;
            case"Воскресенье":
                System.out.println("Домашнее рагу с соком");
                break;



            default:
                System.out.println("Походу вы из параллельной вселенной");
        }
    }
}