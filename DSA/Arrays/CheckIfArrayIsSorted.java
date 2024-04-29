package DSA.Arrays;

public class CheckIfArrayIsSorted {
    public static boolean isSorted(int arr[]) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isSorted(new int[]{1, 2, 3, 5, 4}));
    }
}
