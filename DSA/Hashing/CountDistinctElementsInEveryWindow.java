package DSA.Hashing;

import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    public static void printFreqOfDistinctInEveryWindow(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = k; i < n; i++) {
            System.out.print(map.size() + " ");
            if(map.containsKey(arr[i - k])) {
                if(map.get(arr[i - k]) == 1) {
                    map.remove(arr[i - k]);
                }else {
                    map.put(arr[i - k], map.get(arr[i - k]) - 1);
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size());
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        printFreqOfDistinctInEveryWindow(arr, arr.length, 3);
    }
}
