package DSA.BitMagic;

public class LongestConsecutive1s {
    /**
     * 14 -> 1 1 1 0
     * 222 -> 11011110
     * @param N
     * @return
     */
    public static int maxConsecutiveOnes(int N) {
        // Your code here
        int max = 0, count = 0;
        while (N > 0) {
            if((N & 1) != 0) {
                count++;
                max = Math.max(max, count);
            }else {
                count = 0;
            }
            N >>= 1;
        }
        return max;
    }
    public static void main(String[] args) {
        maxConsecutiveOnes(222);
    }
}
