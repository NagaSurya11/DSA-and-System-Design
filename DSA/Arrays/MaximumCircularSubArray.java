package DSA.Arrays;

public class MaximumCircularSubArray {
    /**
     * @implNote find the total maximum sub array
     * @implNote next find the total sum of array + find the total maximum inversed sub array
     * @implNote return max (step1, step2)
     * @implNote example:
     * @implNote arr = [8, -4, 3, -5, 4]
     * @implNote normalMaxSumSubArray = 8
     * @implNote total = 6
     * @implNote inverseSumSubArray = 6
     * @implNote max(12, 8) = 12
     * @implNote subArray = [4, 8]
     * @implNote here the idea MAX(subtracting the total sum by minimum sum, maxsubarraysum)
     * @implNote Math.max(6 - (-6) ,  8) = 12
     * @return
     */
    public static int solution(int arr[]) {
        int normalMaxSumSubArray = MaxSubarraySum.maxSum(arr);
        // if all are negative
        if(normalMaxSumSubArray < 0) return normalMaxSumSubArray;

        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            arr[i] = -arr[i];
        }
        return Math.max(total + MaxSubarraySum.maxSum(arr), normalMaxSumSubArray);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, -4, 3, -5, 4}));
    }
}
