package DSA.Strings;

public class Isogram {
    // Function to check if a string is Isogram or not.
    static boolean isIsogram(String data) {
        // Your code here

        int freq[] = new int[26];

        for (int i = 0; i < data.length(); i++) {
            freq[data.charAt(i) - 'a']++;
            if (freq[data.charAt(i) - 'a'] > 1)
                return false;
        }
        return true;

    }
}
