package DSA.BitMagic;

/**
 * CountTotalSetBits
 * // need to study
 */
public class CountTotalSetBits {

    static int GetLeftMostSetBit(int n) {
        int pos = 0;

        while (n > 0) {
            pos++;
            n >>= 1;
        }

        return pos;
    }

    static int TotalSetBitsFrom1ToN(int n) {
        int leftMostSetBitInd = GetLeftMostSetBit(n);

        int totalRep, mod;
        int nearestPow;
        int totalSetBitCount = 0;
        int addRemaining = 0;

        int curr = 0; // denotes the number of set bits at
                      // index i

        for (int i = 1; i <= leftMostSetBitInd; ++i) {
            nearestPow = (int) Math.pow(2, i);
            if (nearestPow > n) {
                int lastPow = (int) Math.pow(2, i - 1);
                mod = n % lastPow;
                totalSetBitCount += mod + 1;
            } else {
                if (i == 1 && n % 2 == 1) {
                    totalRep = (n + 1) / nearestPow;
                    mod = nearestPow % 2;
                    addRemaining = 0;
                } else {
                    totalRep = n / nearestPow;
                    mod = n % nearestPow;

                    if (mod >= (nearestPow / 2)) {
                        addRemaining = mod - (nearestPow / 2) + 1;
                    } else {
                        addRemaining = 0;
                    }
                }

                curr = totalRep * (nearestPow / 2)
                        + addRemaining;
                totalSetBitCount += curr;
            }
        }

        return totalSetBitCount;
    }

    public static void main(String[] args) {
        System.out.println(TotalSetBitsFrom1ToN(17));
    }
}