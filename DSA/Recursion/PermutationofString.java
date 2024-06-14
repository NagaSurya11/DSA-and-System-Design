package DSA.Recursion;

public class PermutationofString {
    public static void print(char[] c) {
        for(char i: c) {
            System.out.print(i);
        }
        System.out.print(" ");
    }
    public static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    public static void permutate(char[] c, int x) {
        if(x == c.length - 1) {
            print(c);
            return;
        }
        for(int i = x; i < c.length; i++) {
            swap(c, i, x);
            permutate(c, x + 1);
            swap(c, x, i);
        }
    }
    public static void printAllPossibleValues(String s) {
        permutate(s.toCharArray(), 0);
    }

    public static void main(String[] args) {
        String s = "ABC";
        printAllPossibleValues(s);
    }
}
