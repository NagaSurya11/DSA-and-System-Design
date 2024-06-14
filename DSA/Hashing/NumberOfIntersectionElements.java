package DSA.Hashing;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIntersectionElements {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            if (set.contains(i)) {
                count++;
                set.remove(i);
            }
        }

        return count;
    }
}
