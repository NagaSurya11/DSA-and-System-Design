package DSA.Strings;

public class ImplementStrStr {
    // Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x) {
        // Your code here
        int i = 0;
        while (i <= s.length() - x.length()) {
            if(s.substring(i, i + x.length()).equals(x)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "GeeksForGeeFr", x = "Fr";
        System.out.println(new ImplementStrStr().strstr(s, x));
    }
}
