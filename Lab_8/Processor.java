import java.util.List;
import java.util.stream.Collectors;

public class Processor {

    @DataProcessor
    public List<String> filterAdults(List<String> input) {
        return input.stream()
                .filter(line -> {
                    String[] parts = line.split(",");
                    int age = Integer.parseInt(parts[1]);
                    return age >= 18;
                })
                .collect(Collectors.toList());
    }

    @DataProcessor
    public List<String> uppercaseNames(List<String> input) {
        return input.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    String name = parts[0].toUpperCase();
                    return name + "," + parts[1];
                })
                .collect(Collectors.toList());
    }
}
