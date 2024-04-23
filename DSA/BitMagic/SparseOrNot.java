package DSA.BitMagic;

public class SparseOrNot {
    public static boolean isSparse(int n)
    {
        // Your code here
        return !((n & (n >> 1)) >= 1);
    }

    public static void main(String[] args) {
        System.out.println(isSparse(3));
    }
}
