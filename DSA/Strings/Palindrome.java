package DSA.Strings;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        int index1 = 0;
        int index2 = str.length() - 1;
        while (index1 < index2) {
            if(str.charAt(index1++) != str.charAt(index2--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("AABBAA"));
    }
}
