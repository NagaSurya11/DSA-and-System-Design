package DSA.Strings;

public class Panagram {
    static boolean isPanagram(String s) {
        int freq[] = new int[26];
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(idx >= 0 && idx < 26) {
                freq[idx]++;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) {
                return false;
            }
        }
     return true;   
    }

    public static void main(String[] args) {
        System.out.println(isPanagram("sdfs"));
    }
}
