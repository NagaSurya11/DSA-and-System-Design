package DSA.Strings;

public class NthPrimeDigits {
    // Prints n-th number where each digit is a
    // prime number
    static void nthprimedigitsnumber(long n) {
        // Finding the length of n-th number
        long len = 1;

        // Count of numbers with len-1 digits
        long prev_count = 0;
        while (true) {
            // Count of numbers with i digits
            long curr_count = (long) (prev_count + Math.pow(4, len));

            // if i is the length of such number
            // then n<4*(4^(i-1)-1)/3 and n>= 4*(4 ^ i-1)/3
            // if a valid i is found break the loop
            if (prev_count < n && curr_count >= n)
                break;

            // check for i + 1
            len++;

            prev_count = curr_count;
        }

        // Till now we have covered 'prev_count' numbers

        // Finding ith digit at ith place
        for (int i = 1; i <= len; i++) {
            // j = 1 means 2 j = 2 means ...j = 4 means 7
            for (long j = 1; j <= 4; j++) {
                // if prev_count + 4 ^ (len-i) is less
                // than n, increase prev_count by 4^(x-i)
                if (prev_count + Math.pow(4, len - i) < n)
                    prev_count += Math.pow(4, len - i);

                // else print the ith digit and break
                else {
                    if (j == 1)
                        System.out.print("2");
                    else if (j == 2)
                        System.out.print("3");
                    else if (j == 3)
                        System.out.print("5");
                    else if (j == 4)
                        System.out.print("7");
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        nthprimedigitsnumber(10);
    }
}
