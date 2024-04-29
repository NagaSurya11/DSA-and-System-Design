package DSA.Arrays;

public class MaxLengthOfEvenOddSubArray {
    public static int solution(int arr[]) {
        int res = 1;
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)
                || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                    count++;
                    res = Math.max(res, count);
            }else {
                count = 1;
            }
        }
        return res;
    }
}
