public class main9_10 {
    public static void main(String[] args) {
        String text = "Школьник: Иванов; Иван; Иванович; М; Русский; 170; 60; 1999,12,01; +79129123456; 123456; Россия; Московская область; Подольск; ул. Ленина; 1; 2; школа №1; 5." +
                "Школьник: Петров; Петр; Петрович; М; Украинец; 175; 70; 2000,05,03; +79191987654; 654321; Украина; Киевская область; Киев; ул. Гагарина; 2; 3; школа №2; 6." +
                "Школьник: Сидорова; Анна; Александровна; Ж; Русская; 160; 50; 1999,08,12; +79263333333; 567890; Россия; Московская область; Одинцово; ул. Пушкина; 5; 10; школа №1; 5.";

        String[] objects = text.split("\\.");
        int count = 0;

        for (String obj : objects) {
            String[] fields = obj.split(";");
            if (fields[8].contains("912") || fields[8].contains("919")) {
                if (fields[8].endsWith("5")) {
                    count++;
                }
            }

            if (fields[13].equals("5")) {
                System.out.println(obj);
            }
        }

        System.out.println("Количество людей, у которых в номере телефона есть сочетание цифр 912 или 919 и последняя цифра номера 5: " + count);
    }
}