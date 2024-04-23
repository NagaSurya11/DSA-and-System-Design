public class PrintPrimeFactors {
        /**
     * @implNote most effient method
     * @param n
     */
    public static void solution(int n) {
        while(n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }
        for(int i = 3; i*i <= n; i+=6) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        if (n > 2) System.out.print(n);
    }

    public static void main(String[] args) {
        solution(5);
    }
}
