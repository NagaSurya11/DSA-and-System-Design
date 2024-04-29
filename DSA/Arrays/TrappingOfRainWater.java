package DSA.Arrays;

public class TrappingOfRainWater {

    /**
     * @implNote for example if the current element is 1 its left max value is 3 and right max value is 4 then it will trap 3 - 1 = 2
     * @implNote so we need to 2 arrays based on left most max and right most max
     * @implNote by this we occuppy the min and max of current element then get the min of left and right max and then subtract by original value
     * @param arr
     * @return
     */
    public static int solution(int arr[]) {
        int water = 0;
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        left[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        right[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i>=0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        for(int i = 0; i < arr.length ; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 0, 6, 2, 3}));
    }
}
