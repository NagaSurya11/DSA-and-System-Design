package DSA.BitMagic;

public class OnOddOccuringElements {
    /**
     * 3 ^ 3 = 0;
     * 3 ^ 3 ^ 3 = 0 ^ 3 = 3;
     * @param n
     * @return
     */
    public static int oddOccuringElement(int n[]) {
        int res = n[0];
        for(int i = 1; i < n.length; i++) {
            res ^= n[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(oddOccuringElement(new int[] {4, 4, 1, 5, 5}));
    }
}
