public class DigitsInFactorial {
    /**
     * 2
     * @param N
     * @return
     */
    public static int digitsInFactorial(int N){
        // code here
        if(N == 0) return 0;
        if(N == 1) return 1;
        double digits = 0;
        for(int i = 2; i<= N; i++) {
           digits += Math.log10(i);
        }
        return (int)(Math.floor(digits)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(digitsInFactorial(5));
    }
}
