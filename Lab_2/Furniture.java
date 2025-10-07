abstract class Furniture {
    private String name;
    private String material;
    private double price;
    private static int furnitureCount = 0;

    public Furniture() {
        this.name = "Unknown";
        this.material = "Unknown";
        this.price = 0.0;
        furnitureCount++;
    }
    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
        furnitureCount++;
    }

    public String getName() {
        return name;
    }
    public String getMaterial() {
        return material;
    }
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void getInfo() {
        System.out.println("Название: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price);
    }
    public abstract void use();
    public abstract void burn();

    public static int getCount() {
        return furnitureCount;
    }
}