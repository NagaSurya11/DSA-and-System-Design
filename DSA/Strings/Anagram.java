package DSA.Strings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram {

    static boolean isAnagram(String text, String pattern) {
        int textFreq[] = new int[256];
        int patternFreq[] = new int[256];
        for(int i = 0; i < pattern.length(); i++) {
            textFreq[text.charAt(i)]++;
            patternFreq[pattern.charAt(i)]++;
        }
        for(int i = pattern.length(); i < text.length(); i++) {
            if(Arrays.equals(textFreq, patternFreq)) {
                return true;
            }else {
                textFreq[text.charAt(i - pattern.length())]--;
                textFreq[text.charAt(i)]++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("geeksforgeeks", "eeksr"));
    }
}
