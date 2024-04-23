public class AllDivisorsOfNumber {
    /**
     * @implNote order should be in ascending
     * @param n
     */
    public static void solution(int n) {
        int i;
        for(i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                System.out.print(i + " ");
            }
        }
        for(; i>= 1; i--) {
            if(n % i == 0 && (n / i) != i) {
                System.out.print(n / i + " ");
            }
        }
    }

    public static void main(String[] args) {
        solution(176);
    }
}
