package DSA.Strings;

public class LongestSubstringWithDistinctCharacters {
    static int getLongestSubstringWithDistinctCharacters(String s) {
        int max = 0;
        int prevIdx[] = new int[256];
        int idx = 0;
        for(int i = 0; i < s.length(); i++) {
            idx = Math.max(prevIdx[s.charAt(i)], idx);
            max = Math.max(max, i - idx);
            prevIdx[s.charAt(i)] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubstringWithDistinctCharacters("abcacdbab"));
    }
}
