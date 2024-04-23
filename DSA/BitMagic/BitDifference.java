package DSA.BitMagic;

public class BitDifference {
    public static int countBitsFlip(int a, int b){
        // Your code here
        int count = 0;
        while(a != b) {
            if((a & 1) != (b & 1)) count++;
            a >>= 1;
            b >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        countBitsFlip(10, 20);
    }
}
