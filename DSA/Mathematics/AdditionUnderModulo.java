public class AdditionUnderModulo {
    /**
     * @implNote (a + b) mod m = (a mod m + b mod m) mod m
     */
    public static long sumUnderModulo(long a, long b){
        // code here
        long m = 1000000007;
        return ((a % m) + (b % m)) % m ;
    }

    /**
     * @implNote + is replaced by *
     */
    static long multiplicationUnderModulo(long a, long b)
    {
        // add your code here
        long m = 1000000007;
        return ((a % m) * (b % m)) % m ;
    }
}
