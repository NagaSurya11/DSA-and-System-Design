package DSA.Strings;

import java.util.Stack;

public class LexicographicRank {
    static long fact(long n) {
        long result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    // Function to find lexicographic rank of a string.
        static int findRank(String S) {
            int count[] = new int[256];

            for(int i = 0; i < S.length(); i++) {
                count[S.charAt(i)]++;
            }

            for(int i = 1; i < S.length(); i++) {
                count[S.charAt(i)] += count[S.charAt(i - 1)];
            }

            long res = 1;
            long mul = fact(S.length());
            for(int i = 1; i < S.length() - 1; i++) { // skip the last char and add one in rank
                mul /= S.length() - i;
                res += (count[i - 1] * mul);
                for(int j = S.charAt(i); j < 256; j++) {
                    count[j]--;
                }
            }
            return (int) (res + 1 % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(findRank("acb"));
        Stack<Integer> st = new Stack<>();
        st.re

    }
}
