package DSA.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInAStream {
    Comparator<Integer> maxHeapComparator = (o1, o2) -> Integer.compare(o2, o1);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxHeapComparator);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public void insertHeap(int x) {
        balanceHeaps(x);
    }

    /**
     * [5] [15]
     */
    public void balanceHeaps(int x) {
        if(maxHeap.isEmpty()) {
            maxHeap.add(x);
        }
        else if(maxHeap.size() > minHeap.size()) {
            if(maxHeap.peek() > x) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(x);
            }else {
                minHeap.add(x);
            }
        }else if(x <= maxHeap.peek()) {
            maxHeap.add(x);
        }else {
            minHeap.add(x);
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMedian() {
        return minHeap.size() == maxHeap.size() ?
            (double) (maxHeap.peek() + minHeap.peek()) / (double) 2 : (double) maxHeap.peek();
    }

    public static void main(String[] args) {
        int N = 4, X[] = { 5, 15, 1, 3 };
        MedianInAStream medianInAStream = new MedianInAStream();
        for(int i = 0; i < N; i++) {
            medianInAStream.insertHeap(X[i]);
            System.out.println(Math.floor(medianInAStream.getMedian()));
        }
    }
}
