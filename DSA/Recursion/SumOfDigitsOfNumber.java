package DSA.Recursion;

public class SumOfDigitsOfNumber {
    public static int sumOfDigits(int sum, int n) {
        if (n == 0) {
            return sum;
        }
        return sumOfDigits(sum + (n % 10), n / 10);
    }

    // complete the function
    public static int sumOfDigits(int n) {
        // add your code here
        return sumOfDigits(0, n);
    }
}
