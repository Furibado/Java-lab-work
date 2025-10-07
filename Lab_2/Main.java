import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Table oneLegTable = new Table("Одноножка", "стекло", 1500, 1);
        Chair goodChair = new Chair("Хороший мальчик", "бамбук", 22000, false);
        Bed kingBed = new Bed("Королевская", "золото", 1700000, "Kingsize");

        Chair customChair = new Chair();
        
        System.out.print("Введите название стула: ");
        customChair.setName(sc.nextLine());
        
        System.out.print("Введите материал: ");
        customChair.setMaterial(sc.nextLine());
        
        System.out.print("Введите цену: ");
        customChair.setPrice(sc.nextDouble());
        
        System.out.print("Есть ли на нём пятна (true/false)?: ");
        customChair.setHasStains(sc.nextBoolean());
        sc.close();
        
        System.out.println("Вывод информации о столе:");
        oneLegTable.getInfo();
        oneLegTable.use();
        oneLegTable.getInfo(true);
        oneLegTable.testStability(2);
        oneLegTable.burn();
        
        System.out.println("Вывод информации о стуле:");
        goodChair.getInfo();
        goodChair.use();
        goodChair.burn();
        goodChair.testStains();
        
        System.out.println("Вывод информации о кровати:");
        kingBed.getInfo();
        kingBed.use();
        kingBed.burn();
        System.out.println("Данные об частном стуле: ");
        System.out.println("Название (через геттер): " + customChair.getName());
        customChair.getInfo(true);

        System.out.println("Всего создано объектов мебели: " + Furniture.getCount());
    }
}
