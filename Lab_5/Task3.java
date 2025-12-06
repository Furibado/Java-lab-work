import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Task3 {
    public static void main(String[] args) {
        String text = "I have succeeded so mUch in this liFe, this wOrld is so clear to me, as if I have bEEn lIVing for milLions and trillions of years.";
        try {
            Pattern pattern = Pattern.compile("[a-zа-я][A-ZА-Я]");
            Matcher matcher = pattern.matcher(text);
            
            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                String reText = "!" + matcher.group(1) + matcher.group(2) + "!";
                matcher.appendReplacement(result, reText);
            }
            matcher.appendTail(result);

            System.out.println("Исходный текст: " + text);
            System.out.println("Результат: " + result.toString());
        } 
        catch (PatternSyntaxException e) {
            System.out.println("Ошибка: неправильный синтаксис в регулярном выражении. \n" + e.getDescription());
        } 
        catch (NullPointerException e) {
            System.out.println("Ошибка: текст для поиска не может быть пустым.");
        }

    }
}
