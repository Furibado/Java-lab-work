import java.util.LinkedList;
import java.util.List;

public class Task3 {
    static class Sale {
        String productName;
        double amount;

        Sale(String productName, double amount) {
            this.productName = productName;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = new LinkedList<>();

        addSale(sales, "Хлеб", 40.0);
        addSale(sales, "Чачка пипсов", 180.0);
        addSale(sales, "Колбаса свинной рай", 230.0);
        addSale(sales, "Телефон Xiaomi", 21999.0);
        addSale(sales, "Чачка пипсов", 180.0);
        addSale(sales, "Чачка пипсов", 180.0);
        addSale(sales, "Колбаса свинной рай", 230.0);
        addSale(sales, "Молоко подкоровное", 120.0);

        System.out.println("Список проданных товаров:");
        printSales(sales);

        double totalAmount = calculateTotalAmount(sales);
        System.out.println("Общая сумма продаж: " + totalAmount);

        String popularSale = findPopularSale(sales);
        System.out.println("Наиболее популярный товар: " + popularSale);
    }

    private static void addSale(List<Sale> sales, String productName, double amount) {
        sales.add(new Sale(productName, amount));
    }

    private static void printSales(List<Sale> sales) {
        for (Sale sale : sales) {
            System.out.println("Товар: " + sale.productName + ", сумма: " + sale.amount);
        }
    }

    private static double calculateTotalAmount(List<Sale> sales) {
        double sum = 0.0;
        for (Sale sale : sales) {
            sum += sale.amount;
        }
        return sum;
    }

    private static String findPopularSale(List<Sale> sales) {
        if (sales.isEmpty()) {
            return "Продаж нет";
        }

        String bestProduct = null;
        int bestCount = 0;

        for (Sale s1 : sales) {
            String name = s1.productName;
            int count = 0;

            for (Sale s2 : sales) {
                if (s2.productName.equals(name)) {
                    count++;
                }
            }

            if (count > bestCount) {
                bestCount = count;
                bestProduct = name;
            }
        }

        return bestProduct;
    }
}
