package DSA.BitMagic;

import java.util.HashMap;

public class TwoOddOccuring {
    /**
     * @implNote For this hashing is the optimal solution
     * @param arr
     */
    public static void twoOddOccuringNumber(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            if(map.get(i) != null) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        map.forEach((key, value) -> {
            if(value % 2 != 0) System.out.print(key + " ");
        });
    }

    public static void main(String[] args) {
        twoOddOccuringNumber(new int[]{1, 1, 1, 2, 2, 3, 4, 4});
    }
}
