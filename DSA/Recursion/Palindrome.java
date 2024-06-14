package DSA.Recursion;

public class Palindrome {
    static boolean isPalindrome(String s, int i, int j) {
        if(i == j) {
            return true;
        }else if(i == (j - 1) && s.charAt(j) == s.charAt(i)) {
            return true;
        }else if(s.charAt(j) == s.charAt(i)) {
            return isPalindrome(s, i + 1, j - 1);
        }else {
            return false;
        }
    }
    static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aabbaa"));
    }
}
