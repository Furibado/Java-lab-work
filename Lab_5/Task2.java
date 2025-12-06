import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Task2 {
    public static void main(String[] args) {
        String password = "Qwerty123";
        try {   
            if (isValidPassword(password)) {
                System.out.println("Пароль корректный.");
            } else {
                System.out.println("Пароль не соответствует требованиям.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка: неправильный синтаксис в регулярном выржении. \n" + e.getDescription());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: пароль не может быть пустым.");
        }
    }
    public static boolean isValidPassword(String password) {
        if (password == null) {
            throw new NullPointerException("password is null");
        }
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        Pattern symbols = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher matcher1 = symbols.matcher(password);
        if (!matcher1.matches()) {
            return false;
        }

        Pattern upperCase = Pattern.compile(".*[A-Z].*");
        Matcher matcher2 = upperCase.matcher(password);
        if (!matcher2.matches()) {
            return false;
        }

        Pattern digit = Pattern.compile(".*[0-9].*");
        Matcher matcher3 = digit.matcher(password);
        if (!matcher3.matches()) {
            return false;
        }
        return true;
    }
}
