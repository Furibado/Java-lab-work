public class Primes{
    public static void main(String[] args){
        for (int i = 2; i <= 100; i++){
            if( isPrime(i) == true){
                System.out.print(i + " ");
            }
        }

    }
    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}