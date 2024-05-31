public class main9_9{
    public static void main(String[] args) {
        String text = "ЕЩЁ ЧУТЬ ЧУТЬ И ПРЯМО / В РАЙ / и !ЖИЗНЬ! и ?УДАЛАСЬ? ВАНА БЬЮРИФУЛ ЛАЙФ";

// Удаление комментариев в формате /.../
        text = text.replaceAll("/.*?/", "");

// Удаление комментариев в формате !...!
        text = text.replaceAll("!.*?!", "");

// Удаление комментариев в формате ?...?
        text = text.replaceAll("\\?.*?\\?", "");

// Проверка наличия комментариев
        if (text.contains("/") || text.contains("!") || text.contains("?")) {
            System.out.println("Некоторые комментарии не были удалены");
        } else {
            System.out.println("Комментариев не найдено");
        }

        System.out.println(text);
    }
}
