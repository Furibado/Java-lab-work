import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Item {
    private final String name;
    private final int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + "кг)";
    }
}

class Warehouse {
    private final List<Item> items = new ArrayList<>();
    private int currentBatchWeight = 0;
    private final int maxBatchWeight;

    public Warehouse(int maxBatchWeight) {
        this.maxBatchWeight = maxBatchWeight;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public synchronized List<Item> takeBatch() {
        if (items.isEmpty()) {
            return null;
        }

        List<Item> batch = new ArrayList<>();
        currentBatchWeight = 0;

        while (!items.isEmpty()) {
            Item next = items.get(0);
            if (currentBatchWeight + next.getWeight() > maxBatchWeight) {
                break;
            }
            batch.add(next);
            currentBatchWeight += next.getWeight();
            items.remove(0);
        }

        if (batch.isEmpty()) {
            Item big = items.remove(0);
            batch.add(big);
        }

        System.out.println("Сформирована партия весом " + getBatchWeight(batch)
                + " кг: " + batch);
        return batch;
    }

    private int getBatchWeight(List<Item> batch) {
        int sum = 0;
        for (Item item : batch) {
            sum += item.getWeight();
        }
        return sum;
    }
}

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        Warehouse warehouse = new Warehouse(150);

        warehouse.addItem(new Item("Колесо", 10));
        warehouse.addItem(new Item("14-летний мальчик", 60));
        warehouse.addItem(new Item("Коробка с айфонами", 30));
        warehouse.addItem(new Item("Штанга", 80));
        warehouse.addItem(new Item("Бутыль воды", 20));
        warehouse.addItem(new Item("Мешок картошки", 50));
        warehouse.addItem(new Item("Чёрный пакет с неизвестным тикающим содержимым", 70));

        int loadersCount = 3;
        ExecutorService executor = Executors.newFixedThreadPool(loadersCount);

        Runnable loaderTask = () -> {
            String name = Thread.currentThread().getName();
            while (true) {
                List<Item> batch = warehouse.takeBatch();
                if (batch == null) {
                    System.out.println(name + " видит, что товаров больше нет. Идёт курить.");
                    break;
                }
                int weight = 0;
                for (Item item : batch) {
                    weight += item.getWeight();
                }

                System.out.println(name + " понёс партию весом " + weight + " кг: " + batch);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                System.out.println(name + " выгрузил партию и вернулся на склад.");
            }
        };

        for (int i = 0; i < loadersCount; i++) {
            executor.execute(loaderTask);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Грузчики ушли домой, потому что товары законсились, а грузчики устали.");
    }
}
