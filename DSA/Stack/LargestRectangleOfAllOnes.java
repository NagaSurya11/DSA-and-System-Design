package DSA.Stack;

public class LargestRectangleOfAllOnes {
    static long maxRectangle(long arr[][], long r, long c) {
        long max = MaxRectangularAreaInHistogram.getMaxArea(arr[0], c);
        for(int i = 1; i < r; i++) {
            for(int j = 0; i < c; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
            max = Math.max(max, MaxRectangularAreaInHistogram.getMaxArea(arr[i], c));
        }
        return max;
    }
}
