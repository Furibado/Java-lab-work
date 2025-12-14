import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";

        File file = new File(filePath);

        Map<String, Integer> wordCounts = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.toLowerCase();

                String[] words = line.split("[^a-zA-Zа-яА-Я0-9]+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    int oldCount = wordCounts.getOrDefault(word, 0);
                    wordCounts.put(word, oldCount + 1);
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCounts.entrySet());

        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        System.out.println("Топ 10 слов:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(count + 1 + ") " + entry.getKey() + " : " + entry.getValue());
            count++;
            if (count >= 10) {
                break;
            }
        }
    }
}
