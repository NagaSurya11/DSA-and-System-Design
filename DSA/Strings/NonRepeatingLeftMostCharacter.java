package DSA.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class NonRepeatingLeftMostCharacter {
    // Function to find the first non-repeating character in a string.
    // hello
    static char nonrepeatingCharacter(String S)
        {
            //Your code here
            // two traversal
            // HashMap<Character, Integer> map = new HashMap<>();
            // for(int i = S.length() - 1; i >= 0 ; i--) {
            //         if (map.get(S.charAt(i)) != null) {
            //             map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            //         }
            //         else {
            //             map.put(S.charAt(i), 1);
            //         }
            // }
            // for(int i = 0; i < S.length(); i++) {
            //     if(map.get(S.charAt(i)) == 1) return S.charAt(i);
            // }
            // return '$';

            int freq[] = new int[256];
            for(int i = 0; i < S.length(); i++) {
                if(freq[S.charAt(i)] == 0) {
                    freq[S.charAt(i)] = i + 1;
                }else {
                    freq[S.charAt(i)] = -1;
                }
            }
            int result = S.length();
            for(int i = 0; i < 256; i++) {
                if(freq[i] > 0) {
                    result = Math.min(result, freq[i] - 1);
                }
            }

            return result == S.length() ? '$' : S.charAt(result);
        }

        public static void main(String[] args) {
            System.out.println(nonrepeatingCharacter("zxvczbtxyzvy"));
        }
}
