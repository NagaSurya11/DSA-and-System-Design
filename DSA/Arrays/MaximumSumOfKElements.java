package DSA.Arrays;

public class MaximumSumOfKElements {
    /**
     * @implNote Sliding Window Technique
     * [1, 2, 3, 4, 5]
     * @param arr
     * @return
     */
    public static int solution(int arr[], int k) {
        int res = 0;
        for(int i = 0; i < k; i++) {
            res+= arr[i];
        }

        for(int i = k; i < arr.length; i++) {
            res = Math.max(res, res + arr[i] - arr[i - k]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
