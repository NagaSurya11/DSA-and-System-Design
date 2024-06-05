import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Exactly3Divisors {
    /**
     * @implNote number which sqrt is a exact prime number then it has only 3 divisors
     * @param N
     * @return
     */
    public int exactly3Divisors(int N)
    {
        //Your code here
        HashMap<Integer, Boolean> notPrimes = new HashMap<>();
        // Arrays.fill(isPrime, true);
        int count = 0;
        for(int i = 2; i * i <= N; i++) {
            if(notPrimes.get(i) == null) {
                count++;
                for(int j = i * 2; j * j <= N; j+=i) {
                    notPrimes.put(j, true);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Exactly3Divisors().exactly3Divisors(67));
    }
}
