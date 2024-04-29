package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
    // Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            // find the lowest price
            while (i < n - 1 && A[i + 1] <= A[i]) {
                i++;
            }
            if(i == n - 1) {
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0, i++);

            while (i < n && A[i] >= A[i - 1]) {
                i++;
            }
            list.add(1, i - 1);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4,3, 2, 1};
        int n = arr.length;
        new StockBuyAndSell().stockBuySell(arr, n).forEach(list -> {
            list.forEach(i -> {
                System.out.print(i + " ");
            });
            System.out.println();
        });
    }
}
