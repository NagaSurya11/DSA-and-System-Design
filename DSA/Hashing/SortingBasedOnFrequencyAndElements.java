package DSA.Hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class SortingBasedOnFrequencyAndElements {
    // Function to sort the array according to frequency of elements.
    //That is elements that have higher frequency come first.
    //If frequencies of two elements are same, then smaller number comes first.
    static ArrayList<Integer> sortByFreq(int arr[], int n) {
        // add your code here

        // store freqencies on hashing
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
                list.add(arr[i]);
            } else {
                freqMap.put(arr[i], 1);
                list.add(arr[i]);
            }
        }

        Comparator<Integer> comparator = (o1, o2) -> {
            int freq1 = freqMap.get(o1);
            int freq2 = freqMap.get(o2);
            if(freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            }else {
                return Integer.compare(o1, o2);
            }
        };
        list.sort(comparator);
        return list;
    }

    public static void main(String[] args) {
        int N = 5,
                A[] = { 5, 5, 4, 6, 4 };
        sortByFreq(A, N).forEach(System.out::println);
    }
}
