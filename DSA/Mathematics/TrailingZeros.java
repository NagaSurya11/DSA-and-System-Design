
public class TrailingZeros {
    /**
     * TrailingZeros
     * @implNote (n / 5) + (n / 25) + ...
     * @implNote i <= n
     */
    public static int solution(int n) {
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
    }
}
