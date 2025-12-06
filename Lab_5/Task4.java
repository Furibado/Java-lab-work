import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Task4 {
    public static void main(String[] args) {
        String ip = "192.108.54.1";

        try {
            Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])){3})$");
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("ip адрес корректный");
            }
            else {
                System.out.println("ip адрес некорректный");
            }
        }
        catch (PatternSyntaxException e) {
            System.out.println("Ошибка: неправильный синтаксис в регулярном выражении. \n" + e.getDescription());
        } 
        catch (NullPointerException e) {
            System.out.println("Ошибка: ip не может быть пустым.");
        }
    }
}
