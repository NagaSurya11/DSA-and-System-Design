package DSA.Arrays;

import java.util.ArrayList;

public class LeadersInArray {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(n == 0) return result;
        int currLeader = arr[n - 1];
        result.add(0, currLeader);
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] >= currLeader) {
                currLeader = arr[i];
                result.add(0, currLeader);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        leaders(new int[]{16,17,4,3,5,2}, 6).forEach(a -> {
            System.out.print(a + " ");
        });
    }
}
