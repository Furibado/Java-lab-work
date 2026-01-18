import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int[][] matrix = {
                {1,  2,  3,  4},
                {5, 16,  7,  8},
                {9, 10, 11, 12},
                {0, -5, 20, 6}
        };

        int threads = 4;

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        List<Future<Integer>> results = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {

            final int rowIndex = row;

            Callable<Integer> task = () -> {
                int[] currentRow = matrix[rowIndex];
                int max = Integer.MIN_VALUE;
                for (int value : currentRow) {
                    if (value > max) {
                        max = value;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " обработал строку " + rowIndex + ", максимум в строке = " + max);
                return max;
            };

            results.add(executor.submit(task));
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> f : results) {
            int rowMax = f.get();
            if (rowMax > globalMax) {
                globalMax = rowMax;
            }
        }

        executor.shutdown();

        System.out.println("Максимальный элемент во всей матрице = " + globalMax);
    }
}
