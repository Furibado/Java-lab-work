public class ArrayAverage {
    public static void main(String[] args) {

        Object[] arr = {"1", 2.12d, "3", "four", "5"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                int num;
                if (arr[i] instanceof String){
                    num = Integer.parseInt((String)arr[i]);
                } 
                else if(arr[i] instanceof Double){
                    num = ((Double) arr[i]).intValue();
                }
                else if(arr[i] instanceof Integer){
                    num = (Integer) arr[i];
                }
                else {
                    throw new NumberFormatException("Неподдерживаемый тип: " + arr[i].getClass());
                }
                sum += num;
                count++;
            }

            System.out.println("Среднее арифметическое массива = " + (sum / count));

        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } 
        catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом");
        } 
    }
}