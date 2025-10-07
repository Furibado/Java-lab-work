class Table extends Furniture {
    private int legsNumber;

    public Table() {
        super();
        this.legsNumber = 4;
    }
    public Table(String name, String material, double price, int legsNumber) {
        super(name, material, price);
        this.legsNumber = legsNumber;
    }

    public int getLegsNumber() {
        return legsNumber;
    }
    public void setLegsNumber(int legsNumber) {
        this.legsNumber = legsNumber;
    }

    @Override
    public void use() {
        System.out.println("Вы поставили на стол " + getName() + " кружку чая. Стол не выдержал и разбился.");
    }
    @Override
    public void burn(){
        System.out.println("Стол " + getName() + " был успешно сожжён.");
    }
    public void testStability(int legsNumber){
        if( legsNumber > 2){
            System.out.println("Стол " + getName() + " устойчивый, и вы можете спокойно ставить на него вещи.");
        } else {System.out.println("Стол " + getName() + " крайне не устойчивый и лучше вообще к нему не подходить.");}
    }

    public void getInfo(boolean detailed) {
        super.getInfo();
        if (detailed) {
            System.out.println("Количество ножек: " + legsNumber);
        }
    }
}