package DSA.Arrays;

/**
 * SubArrayWithGivenSum
 */
public class SubArrayWithGivenSum {

    public static boolean hasSubArrayOfSum(int arr[], int sum) {
        int curr_sum = arr[0];
        int curr_idx = 0;
        for(int i = 1; i < arr.length; i++) {
            curr_sum += arr[i];
            while (sum < curr_sum) {
                curr_sum -= arr[curr_idx++];
            }
            if(curr_sum == sum) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {4, 8, 12, 5};
        int sum = 17;
        System.out.println(hasSubArrayOfSum(arr, sum));
    }
}