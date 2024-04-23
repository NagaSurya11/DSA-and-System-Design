package DSA.BitMagic;

public class FirstSetBit {
        //Function to find position of first set bit in the given number.
        public static int getFirstSetBit(int n){
            // Your code here
            int count = 1;
            while(n > 0) {
                if((n & 1) != 0) return count;
                count++;
                n = n >> 1;
            }
            return 0;
        }
}
