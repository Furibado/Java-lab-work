public class Main {

    public static void main(String[] args) throws Exception {

        DataManager manager = new DataManager();

        manager.registerProcessor(new Processor());

        manager.loadData("file.txt");

        manager.processData();

        manager.saveData("result.txt");

        manager.shutdown();
    }
}
