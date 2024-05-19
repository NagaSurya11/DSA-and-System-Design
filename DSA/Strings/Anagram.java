package DSA.Strings;

public class Anagram {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        // Your code here
        // if it also contains uppercase then 256 else we will minus by 'a' hence not
        // more than 26
        int freq[] = new int[26];

        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}
