package DSA.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class PositiveAndNegativePairs {
    // Function to return list containing all the pairs having both
    // negative and positive values of a number in the array.
    public static ArrayList<Integer> findPairs(int arr[], int n) {
        // code here.
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if(set.contains(-i)) {
                if(i < 0) {
                    list.add(i);
                    list.add(-i);
                }else {
                    list.add(-i);
                    list.add(i);
                }
            }else {
                set.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int n = 8,
        arr[] = {1,3,6,-2,-1,-3,2,7};
        findPairs(arr, n).forEach(System.out::println);
    }
}
