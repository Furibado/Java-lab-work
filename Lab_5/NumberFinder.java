import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99. I wish RAM cost $5 now.";

        try{
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String number = matcher.group();
                System.out.println(number);
            }
        }

        catch (PatternSyntaxException e) {
            System.out.println("Ошибка: неправильный синтаксис в регулярном выражении. \n" + e.getDescription());
        }
        catch (NullPointerException e) {
            System.out.println("Ошибка: текст для поиска не может быть пустым.");
        }
    }
}
