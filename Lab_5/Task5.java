import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Task5 {
    public static void main(String[] args) {
        String text = "I have succeeded so much in this life, this world is so clear to me, as if I have been living for millions and trillions of years.";
        char letter = 'h';

        try {
            Pattern pattern = Pattern.compile("\\b[" + Character.toLowerCase(letter) + Character.toUpperCase(letter) + "]\\w*");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
        catch (PatternSyntaxException e) {
            System.out.println("Ошибка: неправильный синтаксис в регулярном выражении. \n" + e.getDescription());
        } 
        catch (NullPointerException e) {
            System.out.println("Ошибка: текст не может быть пустым не может быть пустым.");
        }
    }
}
