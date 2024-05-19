package DSA.Strings;

public class BinaryString {
    /**
     * @implNote total no of sub string or array of n is (n * (n-1)) / 2
     * @param a
     * @param str
     * @return
     */
        //Function to count the number of substrings that start and end with 1.
        public static int binarySubstring(int a, String str)
        {
            // Your code here
            int ones = 0;
            for(int i = 0; i < a; i++) {
                if(str.charAt(i) == '1') ones++;
            }
            return (ones * (ones - 1)) / 2;
        }
}
