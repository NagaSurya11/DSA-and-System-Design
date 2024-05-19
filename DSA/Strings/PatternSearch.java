package DSA.Strings;

public class PatternSearch {
    /**
     * @algorithm Naive Approach
     * @implNote tc = O(n * m)
     * @implNote sc = O(1)
     */
    static class Naive {
        // Function to check if the given pattern exists in the given string or not.
        static boolean search(String pattern, String text) {
            // Your code here
            for (int i = 0; i <= text.length() - pattern.length(); i++) {
                int j;
                for (j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == pattern.length()) {
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * @algorithm Rabin Karp Approach
     * @implNote tc = O(n * m) in worst case if everything matches hash value
     * @implNote sc = O(1)
     */
    static class RabinKarp {
        private static int getHashValueOfCharacter(char c) {
            return c - 'a' + 1;
        }
        private static long getHashValueOString(String s) {
            long value = 0;
            for(int i = 0; i < s.length(); i++) {
                value += getHashValueOfCharacter(s.charAt(i));
            }
            return value;
        }

        private static boolean isMatched(String text, String pattern, int curr_idx) {
            int patternIdx = pattern.length() - 1;
            while (patternIdx >= 0) {
                if(text.charAt(curr_idx--) != pattern.charAt(patternIdx--)) {
                    return false;
                }
            }
            return true;
        }
        public static boolean search(String pattern, String text, int q) {
            long hashOfPattern = getHashValueOString(pattern);
            long hashOfCurrentWindow = 0;
            for(int i = 0; i < pattern.length(); i++) {
                hashOfCurrentWindow += getHashValueOfCharacter(text.charAt(i));
            }
            for(int i = pattern.length(); i <= text.length(); i++) {
                if(hashOfPattern == hashOfCurrentWindow && isMatched(text, pattern, i - 1)) {
                    return true;
                }else if(i == text.length()) {
                    break;
                }
                else {
                    hashOfCurrentWindow -= getHashValueOfCharacter(text.charAt(i - pattern.length()));
                    hashOfCurrentWindow += getHashValueOfCharacter(text.charAt(i));
                }
            }
            return false;

        }
    }

    public static void main(String[] args) {
        // String text = "aabaacaadaabaaabaa";
        // String pattern = "aaba";
        // System.out.println(Naive.search(pattern, text));
        String text = "lkjsdfhaiuehaoewiuraoikdehjakdsfhlsjdkihalieushralkehfailuewhfaklfjsdhfliuewahf";
        String pattern = "ahf";
        System.out.println(RabinKarp.search(pattern, text, 0));
    }
}