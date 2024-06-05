import java.util.Arrays;

public class PrintAllPrimesUptoN {
    /**
     * @implNote using seive of eratosthenes
     * @param n
     */
    public static void solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                System.out.print(i + " ");
                for(int j = i * i; j <= n; j+= i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        solution(10);
    }
}
