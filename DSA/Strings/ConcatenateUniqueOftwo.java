package DSA.Strings;

import java.util.HashMap;

public class ConcatenateUniqueOftwo {
    // Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1, String s2) {
        // Your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, 1); // if in s1 set value as 1
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c) && map.get(c) <= 1) { // if in s1 or already marked as exists set as zero
                map.put(c, 0);
            } else {
                map.put(c, 2);
            }
        }

        String result = "";
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.get(c) != 0) {
                result += c;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.get(c) != 0) {
                result += c;
            }
        }
        return result == "" ? "-1" : result;
    }
}
