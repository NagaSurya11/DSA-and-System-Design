package DSA.BitMagic;

public class AllOperands {

    /**@implNote if both are 1 then 1
     * @implNote 3 -> 0011
     * @implNote 6 -> 0110
     * @implNote 2 -> 0010
     * @param x
     * @param y
     * @return
     */
    public static int and(int x, int y) {
        return x & y;
    }

    /**
     * @implNote if anyone is 1 then 1
     * @implNote 3 -> 0011
     * @implNote 6 -> 0110
     * @implNote 7 -> 0111
     * @param x
     * @param y
     * @return
     */
    public static int or(int x, int  y) {
        return x | y;
    }

    /**
     * @implNote if both are same then 0 else 1
     * @implNote 3 -> 0011
     * @implNote 6 -> 0110
     * @implNote 5 -> 0101
     * @param x
     * @param y
     * @return
     */
    public static int xor(int x, int y) {
        return x ^ y;
    }
    /**
     * @implNote if 1 then 0
     * @param x
     * @return
     */
    public static int not(int x) {
        return ~ x;
    }

    /**
     * @implNote add y zeros at end and trailing y digits are ignored
     * @implNote 3  -> 0011
     * @implNote 12 -> 1100
     * @param x
     * @param y
     * @return
     */
    public static int leftShift(int x, int y) {
        return x << y;
    }

    /**
     * @implNote vise versa of left shift
     * @implNote 12 -> 1100
     * @implNote 3 -> 0011
     * @param x
     * @param y
     * @return
     */
    public static int rightShift(int x, int y) {
        return x >> y;
    }
    /**
     * @implNote add y ones at leading trail spaces
     * @implNote 3  -> 0011
     * @implNote 12 -> 1100
     * @param x
     * @param y
     * @return
     */
    public static int unSignedRightShift(int x, int y) {
        return x >>> y;
    }
    public static void main(String[] args) {
        System.out.println(and(3, 6));
        System.out.println(or(3, 6));
        System.out.println(xor(3, 6));
        System.out.println(not(5));
        System.out.println(leftShift(3, 2));
        System.out.println(rightShift(12, 2));
    }
}
