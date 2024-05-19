package DSA.Strings;

public class MinimumIndexedCharacter {
    // Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt) {
        // Your code here
        int freq[] = new int[256];
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 0) {
                freq[str.charAt(i)] = i + 1;
            }
        }
        int result = str.length();
        for (int i = 0; i < patt.length(); i++) {
            if (freq[patt.charAt(i)] > 0) {
                result = Math.min(freq[patt.charAt(i)] - 1, result);
            }
        }

        return result == str.length() ? -1 : result;
    }
}
