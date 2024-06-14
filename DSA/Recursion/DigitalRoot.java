package DSA.Recursion;

public class DigitalRoot {
    public static int digitalRoot(int sum, int n) {
        if(n == 0) {
            return sum / 10 == 0 ? sum : digitalRoot(0, sum);
        }
        return digitalRoot(sum + (n % 10), n / 10);
    }
    /**
     * @implNote n = 99999
     * @implNote Output: 9
     * @implNote Explanation: Sum of digits of 99999 is 45
     * which is not a single digit number, hence
     * sum of digit of 45 is 9 which is a single
     * digit number.
     * @param n
     * @return
     */
    // complete the function
    public static int digitalRoot(int n) {
        // add your code here
        return digitalRoot(0, n);
    }

    public static void main(String[] args) {
        System.out.println(digitalRoot(99999));
    }
}
