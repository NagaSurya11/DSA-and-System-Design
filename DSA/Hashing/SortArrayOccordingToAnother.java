package DSA.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

/**
 * If elements are repeated in the second array,
 * consider their first occurance only.
 */
public class SortArrayOccordingToAnother {
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]

    // Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < M; i++) {
            if(map.containsKey(A2[i])) {
                continue;
            }else {
                map.put(A2[i], i);
            }
        }
        ArrayList<Integer> inArray2 = new ArrayList<>();
        ArrayList<Integer> notInArray2 = new ArrayList<>();
        for(int num: A1) {
            if(map.containsKey(num)) {
                inArray2.add(num);
            }else {
                notInArray2.add(num);
            }
        }
        inArray2.sort(Comparator.comparingInt(map::get));
        notInArray2.sort(Comparator.naturalOrder());
        int result[] = new int[N];
        int idx = 0;
        for(int num: inArray2) {
            result[idx++] = num;
        }
        for(int num: notInArray2) {
            result[idx++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 11,
        M = 3,
        A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8},
        A2[] = {2, 1, 8};

        for(int i: sortA1ByA2(A1, N, A2, M)) {
            System.out.print(i + " ");
        }
    }
}
