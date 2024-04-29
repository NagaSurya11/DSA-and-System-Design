package DSA.Arrays;

public class MinimumConsecutiveFlips {
    public static void solution(int arr[]) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]) {
                if(arr[i] != arr[0]) {
                    System.out.print("From " + i);
                }else {
                    System.out.println(" To " + (i - 1));
                }
            }
        }

        // if the last single element group is not equal to first
        if(arr[arr.length - 1] != arr[0]) {
            System.out.println(" To " + (arr.length - 1));
        }
    }

    public static void main(String[] args) {
        solution(new int[]{0, 0, 1, 1, 1, 0, 0, 0, 1});
    }
}
