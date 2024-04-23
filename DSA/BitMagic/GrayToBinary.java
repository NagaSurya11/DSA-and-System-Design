package DSA.BitMagic;

public class GrayToBinary {
    static int GetLeftMostSetBit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n >>= 1;
        }
        return count;
    }

    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {

        // Your code here
        if(n == 0 || n == 1) return n;
        int leftMostSetBitInd = GetLeftMostSetBit(n);
        int res = 1 << (leftMostSetBitInd - 1);
        for(int i = leftMostSetBitInd - 1; i >0; i--) {
            int lastGeneratedBit = (res >> i) & 1;
            int currentBit = (n >> (i - 1)) & 1;
            res |= (lastGeneratedBit ^ currentBit) << (i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        grayToBinary(15);
    }
}
