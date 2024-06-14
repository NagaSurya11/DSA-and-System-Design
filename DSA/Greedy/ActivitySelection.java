package DSA.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class ActivitySelection {
    static class Pair {
        int start;
        int end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    // same solution for max meetings can happen in a single room
    public static int activitySelection(int[] start, int[] end, int n) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(start[i], end[i]));
        }
        Comparator<Pair> comparator = (o1, o2) -> Integer.compare(o1.end, o2.end);
        list.sort(comparator);
        int result = 1;
        Pair prev = list.get(0);
        for (int i = 1; i < n; i++) {
            Pair curr = list.get(i);
            if (prev.end < curr.start) {
                result++;
                prev = curr;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 2, 5}, end = {2, 4, 3, 6};
        int n = 4;
        System.out.println(activitySelection(start, end, n));
    }
}
