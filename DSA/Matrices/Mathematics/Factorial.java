/**
 * Factorial
 */
public class Factorial {
    public static long solution(int n) {
        int fact = 1;
        for(int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
