package DSA.Arrays;

public class MaximumConsequtive1s {
    public static int solution(int arr[]) {
        int res = 0;
        int count = 0;
        for(int i: arr) {
            if(i == 0) count = 0;
            else count++;
            res = Math.max(res, count);
        }
        return res;
    }
}
