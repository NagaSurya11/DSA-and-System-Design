package DSA.Matrices;

import java.util.Arrays;

public class MedianOfASortedMatrix {
    static int binaryMedian(int m[][], int r, int c) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            if (min > m[i][0])
                min = m[i][0];
            if (max < m[i][c - 1])
                max = m[i][c - 1];
        }
        int midPos = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            // Find count of elements smaller than mid
            for (int i = 0; i < r; ++i) {

                place += Math.abs(Arrays.binarySearch(m[i], mid) + 1);
            }

            if (place < midPos)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static void main(String[] args) {
        int r = 3, c = 3;
        int m[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        System.out.println("Median is " + binaryMedian(m, r, c));
    }
}
