class Bed extends Furniture {
    private String size;

    public Bed() {
        super();
        this.size = "Unknown";
    }
    public Bed(String name, String material, double price, String size) {
        super(name, material, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void use() {
        System.out.println("Вы легли на кровать " + getName() + " , но она вся скрипит, поэтому уснуть вы так и не смогли.");
    }
    @Override
    public void burn(){
        System.out.println("Кровать " + getName() + " была успешно сожжена.");
    }

    public void getInfo(boolean detailed) {
        super.getInfo();
        if (detailed) {
            System.out.println("Размер: " + size);
        }
    }
}