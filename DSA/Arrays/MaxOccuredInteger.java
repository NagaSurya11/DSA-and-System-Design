package DSA.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuredInteger {
    /**
     * @implNote Initialize a Hash array arr[] to store the occurrence of every element in all the ranges combined.
     * @implNote Iterate over all the N ranges and increment L[i] - 1 by one and decrement R[i] by one.
     * @implNote Run a Loop from 1 to the maximum end value of all the ranges and take the Prefix sum.
     * @param L
     * @param R
     * @param n
     * @param maxx
     * @return
     */
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int L[], int R[], int n, int maxx) {
        int freq[] = new int[maxx];
        for(int i = 0; i < n; i++) {
            freq[L[i] - 1]++;
            if(R[i] < maxx)
                freq[R[i]]--;
        }

        int result = 0;
        int currMax = freq[0];
        for(int i = 1; i < maxx; i++) {
            freq[i] += freq[i - 1];
            if(currMax < freq[i]) {
                currMax = freq[i];
                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4,
        L[] = {1,4,3,1},
        R[] = {15,8,5,4};
        System.out.println(maxOccured(L, R, n, 15));
    }

}
