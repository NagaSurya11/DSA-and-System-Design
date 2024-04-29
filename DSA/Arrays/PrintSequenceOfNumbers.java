package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://www.geeksforgeeks.org/batch/interview-101-9/track/DSASP-Arrays/problem/print-pattern3549
 */
public class PrintSequenceOfNumbers {
    public List<Integer> addPattern(int x, int n, boolean isIncrement, List<Integer> list) {

        list.add(x);
        if (x == n) {
            return list;
        }
        if (isIncrement || x <= 0) {
            x += 5;
            return addPattern(x, n, true, list);
        } else {
            x -= 5;
            return addPattern(x, n, false, list);
        }
    }

    public List<Integer> pattern(int N) {
        // code here
        List<Integer> list = new ArrayList<>();
        list.add(N);
        if (N <= 0)
            return list;
        return addPattern(N - 5, N, false, list);

    }
}
