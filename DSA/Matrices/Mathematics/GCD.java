/**
 * GCD
 */
public class GCD {
    public static int solution(int a, int b) {
        if(b == 0) return a;
        return solution(b, a % b);
    }
}