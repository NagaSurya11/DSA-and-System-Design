package DSA.Strings;

/**
 * @algorithm KPN
 */
public class SearchPattern {
    /**
     * 
     * @param S
     * @param lps
     * 
     * @implNote initially lps[0] = 0, i = 1, len = 0;
     * @implNote if(S[i] == S[len]) len++, lps[i] = len;
     * @implNote else {
     *           if(len == 0) lps[i] = 0, i++;
     *           else len = lps[len - 1];
     *           }
     */
    static void computeLPSArray(String pat, int M, int lps[]) {
        // Your code here
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else if (len == 0) {
                lps[i++] = 0;
            } else {
                len = lps[len - 1];
            }
        }

    }

    // Function to check if the pattern exists in the string or not.
    static boolean KMPSearch(String pat, String txt) {
        // Your code here
        int n = txt.length();
        int m = pat.length();
        int lps[] = new int[m];
        computeLPSArray(pat, m, lps);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return true;
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(KMPSearch("ababa", "ababcszdgergraegesfwegfwesfaewgwesfFWWEFWEGFAWEGRAWEHBwrnHTEababa"));
    }
}
