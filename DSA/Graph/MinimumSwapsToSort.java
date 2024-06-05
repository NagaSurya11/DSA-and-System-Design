package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;


public class MinimumSwapsToSort {
    public class Pair {
        int element;
        int index;

        Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }
    /**
     * sort the list with pair of index and element
     * compare with org array and create a cycle to swap
     * @param nums
     * @return
     */
    public int minSwaps(int nums[])
    {
        // Code here
        int swaps = 0;
        ArrayList<Pair> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            list.add(new Pair(nums[i], i));
        }
        list.sort(((o1, o2) -> Integer.compare(o1.element, o2.element)));
        boolean[] visited = new boolean[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i] && i != list.get(i).index) {
                int j = i;
                int cycles = 0;
                while (!visited[j]) {
                    visited[j] = true;
                    j = list.get(j).index;
                    cycles++;
                }
                if(cycles > 0) {
                    swaps += cycles - 1;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        new MinimumSwapsToSort().minSwaps(new int[]{2, 8, 5, 4});
    }
}
