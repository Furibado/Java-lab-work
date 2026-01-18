import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int threads = 4;

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        List<Future<Integer>> results = new ArrayList<>();

        int partSize = array.length / threads;
        int start = 0;

        for (int i = 0; i < threads; i++) {
            int from = start;
            int to = (i == threads - 1) ? array.length : start + partSize;

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int j = from; j < to; j++) {
                    sum += array[j];
                }
                System.out.println(Thread.currentThread().getName() + " считал от " + from + " до " + to + " сумма = " + sum);
                return sum;
            };

            results.add(executor.submit(task));

            start = to;
        }

        int total = 0;
        for (Future<Integer> f : results) {
            total += f.get();
        }

        executor.shutdown();

        System.out.println("Итоговая сумма: " + total);
    }
}
