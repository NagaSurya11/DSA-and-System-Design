package DSA.BitMagic;

public class CountSetBits {
    // /**
    //  * O(count)
    //  * @param n
    //  * @return
    //  */
    // public static int countOfSet(int n) {
    //     int count = 0;
    //     while (n > 0) {
    //         n = n & (n - 1);
    //         count++;
    //     }
    //     return count;
    // }
    /**
     * O ( 1 )
     * @param n
     * @return
     */
    public static int countOfSet(int n) {
        int tbl[] = new int[256];
        tbl[0] = 0;
        for(int i = 1; i < 256; i++) {
            tbl[i] = tbl[i & (i - 1)] + 1;
        }
        return tbl[n & 255] + tbl[(n >> 8) & 255] + tbl[(n >> 16) & 255] + tbl[(n >> 24)];
        }

    public static void main(String[] args) {
        System.out.println(countOfSet(7));
    }
}
