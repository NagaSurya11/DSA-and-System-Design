package DSA.Strings;

public class SubSequence {
    public static boolean isSubSequence(String s1, String s2) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < s1.length() && idx2 < s2.length()) {
            if(idx2 == s2.length() - 1 && s1.charAt(idx1) == s2.charAt(idx2)) {
                return true;
            }else if(s1.charAt(idx1) == s2.charAt(idx2)) {
                idx1++;
                idx2++;
            }else {
                idx1++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubSequence("ABCDE", "ACE"));
    }
}
