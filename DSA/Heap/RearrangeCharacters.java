package DSA.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeCharacters {

    // static class Pair {
    // int freq;
    // char c;

    // Pair(char c, int freq) {
    // this.freq = freq;
    // this.c = c;
    // }
    // }

    // // time complexity exceeds
    // static String rearrange(String s) {

    // int[] freq = new int[26];
    // for (int i = 0; i < s.length(); i++) {
    // freq[s.charAt(i) - 'a']++;
    // }
    // Comparator<Pair> comparator = (o1, o2) -> Integer.compare(o2.freq, o1.freq);
    // PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);

    // for (int i = 0; i < 26; i++) {
    // if (freq[i] > 0) {
    // queue.add(new Pair((char) (i + 'a'), freq[i]));
    // }
    // }

    // s = "";
    // Pair prev = new Pair('#', 0);
    // while (!queue.isEmpty()) {
    // Pair curr = queue.poll();
    // s += curr.c;
    // if (prev.freq > 0) {
    // queue.add(prev);
    // }
    // curr.freq--;
    // prev = curr;
    // }
    // return s;
    // }

    static final int MAX_CHAR = 26;

    static int getMaximumAppearingCharacter(int[] freq, int prev) {
        int result = -1;
        int max = 0;
        for (int i = 0; i < MAX_CHAR; i++) {
            if (max < freq[i] && i != prev) {
                max = freq[i];
                result = i;
            }
        }
        return result;
    }

    static String rearrange(String s) {

        int[] freq = new int[MAX_CHAR];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int maxApperaingCharacter = getMaximumAppearingCharacter(freq, -1);
        s = "";
        while (maxApperaingCharacter != -1) {
            s += (char) (maxApperaingCharacter + 'a');
            freq[maxApperaingCharacter]--;
            maxApperaingCharacter = getMaximumAppearingCharacter(freq,
                    maxApperaingCharacter);
        }
        return s;
    }

    public static void main(String[] args) {
        rearrange("geeksforgeeks");
    }
}
