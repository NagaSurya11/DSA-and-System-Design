/**
 * GPTerm
 */
public class GPTerm {
    public double termOfGP(int A, int B, int N) {
        if(N == 1) return A;
        if(N == 2) return B;
        double r = (double) B / (double) A;
        double nThTerm = B;
        for(int i = 3; i <= N; i++) {
            nThTerm *= r;
        }
        return nThTerm;
    }

    public static void main(String[] args) {
        System.out.println(new GPTerm().termOfGP(84, 87, 3));
    }
}