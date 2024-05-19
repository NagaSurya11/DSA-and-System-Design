package DSA.Strings;

/**
 * @link https://www.geeksforgeeks.org/batch/interview-101-9/track/DSASP-Strings/problem/the-modified-string-1587115621
 */
public class TheModifiedString {
    // Function to find minimum number of characters which Ishaan must insert
    // such that string doesn't have three consecutive same characters.
    public static long modified(String a) {
        // Your code here
        int freq[] = new int[256];
        long count = 0;
        freq[a.charAt(0)]++;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) != a.charAt(i - 1)) {
                freq[a.charAt(i - 1)] = 0;
                freq[a.charAt(i)]++;
            } else if (freq[a.charAt(i)] > 1) {
                freq[a.charAt(i)] = 1;
                count++;
            } else {
                freq[a.charAt(i)]++;
            }
        }
        return count;   
    }
}
