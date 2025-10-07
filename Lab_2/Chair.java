class Chair extends Furniture {
    private boolean hasStains;

    public Chair() {
        super();
        this.hasStains = false;
    }
    public Chair(String name, String material, double price, boolean hasStains) {
        super(name, material, price);
        this.hasStains = hasStains;
    }

    public boolean hasStains() {
        return hasStains;
    }
    public void setHasStains(boolean hasStains) {
        this.hasStains = hasStains;
    }

    @Override
    public void use() {
        System.out.println("Вы садитесь на стул " + getName() + ", но он вас не выдерживает и ломается.");
    }
    @Override
    public void burn(){
        System.out.println("Стул " + getName() + " был успешно сожжён.");
    }
    public void testStains() {
        if (hasStains) {
            System.out.println("Стул " + getName() + " имеет странные пятна. Он слишком грязный, чтобы на нём сидеть.");
        } else {
            System.out.println("Стул " + getName() + " без пятен. Можешь даже облизать, если хочешь.");
        }
    }
    public void getInfo(boolean detailed) {
        super.getInfo();
        if (detailed) {
            System.out.println("Наличие пятен: " + hasStains);
        }
    }
}