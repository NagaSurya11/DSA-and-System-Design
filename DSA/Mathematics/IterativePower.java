public class IterativePower {
    /**
     * effiecient solution
     * @param x
     * @param n
     * @implNote using binary method   1 2 4 8 16 32 64 ...
     */
    public static int solution(int x, int n) {
        int res = 1;
        while (n > 0) {
            if(n % 2 != 0) res *= x;
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5));
    }
}
