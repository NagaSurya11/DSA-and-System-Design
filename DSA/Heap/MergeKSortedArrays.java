package DSA.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class Triplet {
        int element;
        int index; // index of current array
        int arrIndex; // index of arr[][]
        static Comparator<Triplet> comparator = (o1, o2) -> Integer.compare(o1.element, o2.element);
        Triplet getNextElementIfExists(int[][] arr) {
            if (index + 1 < arr[arrIndex].length) {
                return new Triplet(arr[arrIndex][index + 1], index + 1, arrIndex);
            }else {
                return null;
            }
        }
        Triplet(int element, int index, int arrIndex) {
            this.arrIndex = arrIndex;
            this.element = element;
            this.index = index;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();

        PriorityQueue<Triplet> queue = new PriorityQueue<>(Triplet.comparator);// min-heap
        for(int i = 0; i < K; i++) {
            queue.add(new Triplet(arr[i][0], 0, i));
        }

        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            list.add(triplet.element);

            Triplet next = triplet.getNextElementIfExists(arr);
            if(next != null) {
                queue.add(next);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int K = 3,
        arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        mergeKArrays(arr, K).forEach(System.out::println);
    }
}
