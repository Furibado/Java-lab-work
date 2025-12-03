import java.io.*;

public class Task2 {
    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("file1.txt");
             FileOutputStream out = new FileOutputStream("file2.txt")) {
            
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

            System.out.println("Файл скопирован без проблем");

        } 
        catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла");
        }
    }
}
