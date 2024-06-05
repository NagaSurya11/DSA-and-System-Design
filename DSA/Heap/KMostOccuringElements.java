package DSA.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class KMostOccuringElements {
    /**
     * Pair
     */
    public class Pair {
        int key;
        int freq;
        Pair(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }
        //Function to print the sum of frequencies of k numbers
    //with most occurrences in an array.
    int kMostFrequent(int arr[], int n, int k){
        // your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            }
        }
        PriorityQueue<Pair> priorityQueue
            = new PriorityQueue<>((o1, o2) -> {
                return Integer.compare(o2.freq, o1.freq);
            });
        map.keySet().forEach(key -> {
            priorityQueue.add(new Pair(key, map.get(key)));
        });
        int total = 0;
        for(int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            total += priorityQueue.poll().freq;
        }
        return total;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 5, 5, 1, 7, 8};
        int k = 3;
        new KMostOccuringElements().kMostFrequent(arr, arr.length, k);
    }
}
