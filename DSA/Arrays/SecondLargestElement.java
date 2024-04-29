package DSA.Arrays;

public class SecondLargestElement {
    public static int getSecondLargestElement(int[] arr) {
        int secondLargestElementIdx = -1;
        int largestElementIdx = 0;
        for(int i = 1; i < arr.length; i++) {
            if(secondLargestElementIdx != -1 && arr[secondLargestElementIdx] < arr[i]) {
                if(arr[largestElementIdx] < arr[i]) {
                    secondLargestElementIdx = largestElementIdx;
                    largestElementIdx = i;
                }
            }else if(arr[largestElementIdx] != arr[i]){
                if(secondLargestElementIdx == -1 || arr[secondLargestElementIdx] < arr[i]) {
                    secondLargestElementIdx = i;
                }
            }
        }
        return secondLargestElementIdx;
    }

    public static void main(String[] args) {
        System.out.println(getSecondLargestElement(new int[]{1, 2, 3, 4, 5}));
    }
}
