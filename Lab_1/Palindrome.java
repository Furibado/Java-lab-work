public class Palindrome {
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            String s = args[i];
            if(isPalindrome(s) == true){
                System.out.println(s + " это палиндромом");
            }
            else{
                System.out.println(s + " не палиндром");
            }
        }
    }
    public static String reverseString(String s){
        String inverse = "";
        for(int i = s.length() - 1; i >= 0; i--){
            inverse += s.charAt(i);
        }
        return inverse;
    }
    public static boolean isPalindrome(String s){
        String inverse = reverseString(s);
        return s.equals(inverse); 
    }
}
