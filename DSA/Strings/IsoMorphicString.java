package DSA.Strings;

import java.util.HashMap;

public class IsoMorphicString {
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2) {
        // Your code here
        if (str1.length() != str2.length())
            return false;

        HashMap<Character, Character> charCount = new HashMap<>();
        char c = 'a';
        for (int i = 0; i < str1.length(); i++) {
            if (charCount.containsKey(str1.charAt(i))) {
                c = charCount.get(str1.charAt(i));
                if (c != str2.charAt(i))
                    return false;
            } else if (!charCount.containsValue(
                    str2.charAt(i))) {
                charCount.put(str1.charAt(i),
                        str2.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}
