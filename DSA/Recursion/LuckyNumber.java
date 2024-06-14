package DSA.Recursion;

public class LuckyNumber {
    public static boolean isLucky(int n, int counter) {
        if(n % counter == 0) {
            return false;
        }
        if(n < counter) {
            return true;
        }

        return isLucky(n - (n / counter), counter + 1);
    }
    /**
     * @param n
     * @return
     */
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n) {
        // Your code here
        return isLucky(n, 2);
    }

    public static void main(String[] args) {
        System.out.println(isLucky(19));
    }
}
