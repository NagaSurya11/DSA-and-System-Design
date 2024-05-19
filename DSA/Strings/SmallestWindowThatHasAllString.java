package DSA.Strings;

public class SmallestWindowThatHasAllString {
    // static String findSubString(String str, String pat) {
    //     int len1 = str.length();
    //     int len2 = pat.length();
 
    //     // Check if string's length is 
    //     // less than pattern's
    //     // length. If yes then no such 
    //     // window can exist
    //     if (len1 < len2) {
    //         System.out.println("No such window exists");
    //         return "";
    //     }
 
    //     int hash_pat[] = new int[256];
    //     int hash_str[] = new int[256];
 
    //     // Store occurrence ofs 
    //     // characters of pattern
    //     for (int i = 0; i < len2; i++)
    //         hash_pat[pat.charAt(i)]++;
 
    //     int start = 0, start_index = -1,
    //         min_len = Integer.MAX_VALUE;
 
    //     // Start traversing the string
    //     // Count of characters
    //     int count = 0; 
    //     for (int j = 0; j < len1; j++) { // timetopractice // toc
           
    //         // Count occurrence of characters 
    //         // of string
    //         hash_str[str.charAt(j)]++;
 
    //         // If string's char matches 
    //         // with pattern's char
    //         // then increment count
    //         if (hash_str[str.charAt(j)]
    //             <= hash_pat[str.charAt(j)])
    //             count++;
 
    //         // If all the characters are matched
    //         if (count == len2) {
               
    //             // Try to minimize the window
    //             while (hash_str[str.charAt(start)]
    //                        > hash_pat[str.charAt(start)]
    //                    || hash_pat[str.charAt(start)]
    //                           == 0) {
 
    //                 if (hash_str[str.charAt(start)]
    //                     > hash_pat[str.charAt(start)])
    //                     hash_str[str.charAt(start)]--;
    //                 start++;
    //             }
 
    //             // update window size
    //             int len_window = j - start + 1;
    //             if (min_len > len_window) {
    //                 min_len = len_window;
    //                 start_index = start;
    //             }
    //         }
    //     }
 
    //     // If no window found
    //     if (start_index == -1) {
    //         System.out.println("No such window exists");
    //         return "";
    //     }
 
    //     // Return substring starting 
    //     // from start_index
    //     // and length min_len
    //     return str.substring(start_index,
    //                          start_index + min_len);
    // }

    /**
     * @param s
     * @param p
     * @return
     */
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int n = s.length();
        int m = p.length();
        if(n < m) return "-1";
        int freq_of_s[] = new int[256];
        int freq_of_p[] = new int[256];
        for(int i = 0; i < m; i++) {
            freq_of_p[p.charAt(i)]++;
        }
        int count = 0;
        int start = 0;
        int min_length = n + 1; // min length will have a worst case chance of n
        int start_idx = -1;
        for(int i = 0; i < n; i++) {
            freq_of_s[s.charAt(i)]++;
            if(freq_of_s[s.charAt(i)] <= freq_of_p[s.charAt(i)]) {
                count++;
            }
            if(count == m) {
                while (freq_of_s[s.charAt(start)] > freq_of_p[s.charAt(start)] 
                    || freq_of_p[s.charAt(start)] == 0) { // if the char over exists or not needed reduce window size
                    if(freq_of_s[s.charAt(start)] > freq_of_p[s.charAt(start)]) {
                        freq_of_s[s.charAt(start)]--;
                    }
                    start++;
                }
                if(min_length > i - start + 1) {
                    min_length = i - start + 1;
                    start_idx = start;
                }
            }
        }
        return (start_idx == -1) ? "-1" :  s.substring(start_idx, start_idx + min_length);
    }
    public static void main(String[] args) {
        smallestWindow("timetopractice", "toc");
    }
}
