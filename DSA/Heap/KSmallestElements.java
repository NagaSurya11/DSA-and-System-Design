package DSA.Heap;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class KSmallestElements {
    static ArrayList<Integer> getKSmallIntegersWithLessDifference(int[] arr, int k, int X) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o2.getKey(), o1.getKey());
        });
        for (int i = 0; i < k; i++) {
            queue.add(Map.entry(Math.abs(arr[i] - X), i));
        }

        for(int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - X);
            if(queue.peek().getKey() > diff) {
                queue.poll();
                queue.add(Map.entry(diff, i));
            }
        }
        while (!queue.isEmpty()) {
            list.add(0, arr[queue.poll().getValue()]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 35, 37, 39, 40};
        int k = 3;
        int X = 36;
        getKSmallIntegersWithLessDifference(arr, k, X).forEach(System.out::println);
    }
}
