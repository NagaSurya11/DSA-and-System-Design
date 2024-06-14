package DSA.Recursion;

public class Power {


    // Recursive function to compute power modulo
    static long powerMod(int base, int exponent, long modulus) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base % modulus;
        } else if (exponent % 2 == 0) {
            long halfPower = powerMod(base, exponent / 2, modulus);
            return ((halfPower * halfPower) % modulus);
        } else {
            long halfPower = powerMod(base, (exponent - 1) / 2, modulus);
            return (((halfPower * halfPower) % modulus) * (base)) % modulus;
        }
    }

    // Function to compute N^R % 10^7
    static long power(int N, int R) {
        long modulus = (long) (Math.pow(10, 9) + 7);
        return powerMod(N, R, modulus);
    }

    /**
     * for small numbers
     * @param n
     * @param p
     * @return
     */
    static int RecursivePower(int n,int p)
    {
        // add your code here
        if(p == 0) {
            return 1;
        }
        if(p == 1) {
            return n;
        }
        
        return n * RecursivePower(n, p - 1);
    }


    public static void main(String[] args) {
        System.out.println(power(12, 21));
    }

}
