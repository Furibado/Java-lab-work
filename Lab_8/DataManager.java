import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DataManager {

    private final List<Object> processors = new ArrayList<>();

    private List<String> rawData = new ArrayList<>();
    private List<String> processedData = new ArrayList<>();

    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void registerProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String filePath) throws IOException {
        rawData = Files.readAllLines(Paths.get(filePath));
        System.out.println("Загружены данные: " + rawData);
    }

    public void processData() throws Exception {
        if (rawData.isEmpty()) {
            System.out.println("Нет данных для обработки.");
            return;
        }

        List<Future<List<String>>> futures = new ArrayList<>();

        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {

                    Callable<List<String>> task = () -> {
                        @SuppressWarnings("unchecked")
                        List<String> result =
                                (List<String>) method.invoke(processor, rawData);
                        System.out.println("Метод " + method.getName()
                                + " выполнен в потоке "
                                + Thread.currentThread().getName());
                        return result;
                    };

                    futures.add(executor.submit(task));
                }
            }
        }

        processedData = new ArrayList<>();
        for (Future<List<String>> f : futures) {
            processedData.addAll(f.get());
        }

        System.out.println("Итоговые данные: " + processedData);
    }

    public void saveData(String filePath) throws IOException {
        Files.write(Paths.get(filePath), processedData);
        System.out.println("Результат сохранён в " + filePath);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
