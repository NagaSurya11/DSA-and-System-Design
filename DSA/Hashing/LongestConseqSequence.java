package DSA.Hashing;

import java.util.HashSet;

public class LongestConseqSequence {
    // arr[] : the input array
    // N : size of the array arr[]

    // Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N) {
        // add your code here
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr) {
            set.add(i);
        }

        int result = 0;
        for (int i: set) {
            if (!set.contains(i - 1)) {
                int curr = i;
                while (set.contains(curr)) {
                    curr++;
                }
                result = Math.max(curr - i, result);
            }
        }
        return result;
    }
}
