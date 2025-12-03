import java.io.FileWriter;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        String value = "12space5";

        try {
            int number = parseNumber(value);
            System.out.println("Число = " + number);

        } 
        catch (CustomNumberFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
            logException(e);
        }
    }

    public static int parseNumber(String s) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(s);
        } 
        catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Ошибка: строка '" + s + "' не является числом");
        }
    }

    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(e.toString() + "\n");
        } 
        catch (IOException ex) {
            System.out.println("Ошибка записи в лог-файл");
        }
    }
}