package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PrefixSum {
    /**
     * Queries
     */
    public static class Queries {
        int x;
        int y;
        Queries(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void solution(int arr[], ArrayList<Queries> queries) {
        // preprocess sum for every index which contains prefix sum
        int preSum[] = new int[arr.length];
        preSum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            preSum[i] = arr[i] + preSum[i - 1];
        }

        // execute queries
        queries.forEach(query -> {
            System.out.print(query.x + " to " + query.y + " = ");
            if (query.x == 0) {
                System.out.println(preSum[query.y]);
            }else {
                System.out.println(preSum[query.y] - preSum[query.x - 1]);
            }
        });
    }

    public static void main(String[] args) {
        int arr[] = {1,2, 3, 4, 5};
        ArrayList<Queries> queries = new ArrayList<>(
            List.of(
                new Queries(0, 3),
                new Queries(2, 3)
            )
        );

        solution(arr, queries);
    }
}
