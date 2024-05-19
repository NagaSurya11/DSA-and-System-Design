package DSA.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * CipherKey
 */
public class CipherKey {
    public static String getCipherKeyString(String original, String key) {
        int plainIdx = 0;
        HashMap<Character, Character>map = new HashMap<>();
        int freq[] = new int[26];
        for(int i = 0; i < original.length(); i++) {
            if(!map.containsValue(original.charAt(i))) {
                map.put((char) ('a' + plainIdx++), original.charAt(i));
                freq[original.charAt(i) - 'a']++;
            }
        }
        int cipherIndex = 0;
        while (plainIdx < 26 && cipherIndex < 26) {
            while (freq[cipherIndex] > 0) {
                cipherIndex++;
            }
            map.put((char) ('a' + plainIdx++), (char) ('a' + cipherIndex++));
        }
        // for getting plain and cipher
        // for(Map.Entry<Character, Character> set: map.entrySet()) {
        //     System.out.println(set.getKey() + " -> " + set.getValue());
        // }
        String result = "";
        for(int i = 0; i < key.length(); i++) {
            result += map.get(key.charAt(i));
        }
        return result;
    }
    public static void main(String[] args) {
        getCipherKeyString("apple", "abcde");
    }
}