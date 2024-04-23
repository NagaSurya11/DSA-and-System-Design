package DSA.BitMagic;

public class PowerOfTwo {
    public static boolean isPowOf2(int x) {
        if(x == 0) return false;
        return (x & (x - 1)) == 0;
    }
}
