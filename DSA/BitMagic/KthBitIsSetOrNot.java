package DSA.BitMagic;

public class KthBitIsSetOrNot {
    /**
     * 3 -> 0 0 1 1
     * @param x
     * @param n
     */
    public static void iskthSet(int x, int k) {
        int a = x >> (k - 1);
        if((a & 1) != 0) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        iskthSet(3, 2);
    }
}
