package DSA.BitMagic;

public class RightMostDifferentBit {

    /**
     * 11 -> 1 0 1 1
     * 9 ->  1 0 0 1
     * @param m
     * @param n
     * @return
     */
    public static int posOfRightMostDiffBit(int m, int n) {
        int result = 0;
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        while (min >= 0 && max > 0) {
            if((min & 1) != (max & 1)) return ++result;
            min >>= 1;
            max >>= 1;
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(11, 9));
    }
}
