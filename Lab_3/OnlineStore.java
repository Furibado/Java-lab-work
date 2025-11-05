import java.util.HashMap;
import java.util.Map;

public class OnlineStore {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(String article, Product product) {
        products.put(article, product);
    }

    public Product getProduct(String article) {
        return products.get(article);
    }

    public void removeProduct(String article) {
        products.remove(article);
    }

    public void printProducts() {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.println("Артикул: " + entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        OnlineStore kupiGovno = new OnlineStore();

        kupiGovno.addProduct("A101", new Product("Ноутбук", "Игровой", 129999.99, 2));
        kupiGovno.addProduct("A102", new Product("Ноутбук", "Ager", 39999.99, 13));
        kupiGovno.addProduct("B201", new Product("Телефон", "Sasung s25", 57999.00, 4));
        kupiGovno.addProduct("B202", new Product("Телефон", "Xiami ultra mega x pro 12 5g 2sim", 29999.50, 10));
        kupiGovno.addProduct("B203", new Product("Телефон", "Ihone 17 pro", 219999.00, 40));
        kupiGovno.addProduct("C301", new Product("Наушники", "Lofictech", 12999.00, 8));
        kupiGovno.addProduct("C302", new Product("Наушники", "JBG", 7999.00, 11));

        System.out.println("Список товаров:");
        kupiGovno.printProducts();

        System.out.println("Ищем товар по артикулу B202:");
        System.out.println(kupiGovno.getProduct("B202"));

        System.out.println("Удаляем товар C301:");
        kupiGovno.removeProduct("C301");
        kupiGovno.printProducts();
    }
}
