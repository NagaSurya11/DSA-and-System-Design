package DSA.Strings;

public class CheckIfTheStringIsRotated2Times {
    static void computeLPSArray(String pat, int M, int lps[], int start) {
        // Your code here
        lps[0] = 0;
        int i = start;
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
    static boolean KMPSearch(String pat, String txt, int start, int end) {
        // Your code here
        int n = txt.length();
        // int m = pat.length();
        int m = end - start;
        int lps[] = new int[m];
        computeLPSArray(pat, m, lps, start);

        int i = start;
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
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        if(str1.length() != str2.length()) return false;
        boolean isClockWise = true;
        boolean isAntiClockWise = true;
        int n = str1.length();
        for(int i = 0; i < n; i++) {
            if(str1.charAt((i + 2) % n) != str2.charAt(i)) {
                isClockWise = false;
                break;
            }
        }
        if(isClockWise) {
            return true;
        }else {
            for(int i = 0; i < n; i++) {
                if(str2.charAt((i + 2) % n) != str1.charAt(i)) {
                    isAntiClockWise = false;
                    break;
                }
            }
            return isAntiClockWise;
        }
    }

    public static void main(String[] args) {
        System.out.println(isRotated("geeksforgeeks", "geeksgeeksfor"));
    }
}
