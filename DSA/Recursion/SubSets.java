package DSA.Recursion;

import java.util.ArrayList;

public class SubSets {
    static void powerSet(String s, String curr, int i, ArrayList<String> list) {
        if ( i == s.length() ) {
            list.add(curr);
            return;
        }

        powerSet(s, curr, i + 1, list);
        powerSet(s, curr + s.charAt(i), i + 1, list);
    }
    // Function to return the lexicographically sorted power-set of the string.
    static ArrayList<String> powerSet(String s) {
        // add your code here
        ArrayList<String> list = new ArrayList<>();
        powerSet(s, "", 0, list);
        return list;
    }

    public static void main(String[] args) {
        powerSet("abc").forEach(value -> {
            System.out.print(value + " ");
        });
    }
}
