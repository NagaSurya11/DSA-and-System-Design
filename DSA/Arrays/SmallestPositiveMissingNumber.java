package DSA.Arrays;

public class SmallestPositiveMissingNumber {
    /**
     * @implNote swaps all valid elements
     * @param arr
     * @return the total no of valid elements
     */
    static int swapAllValidNumbers(int arr[]) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int temp = arr[idx];
                arr[idx++] = arr[i];
                arr[i] = temp;
            }
        }
        return idx;
    }

    /**
     * @implNote Move the all elements lessthan or equal to zero to right
     * @implNote traverse upto valid elements and replace the arr[arr[i]] as
     *           negative if exists
     * @implNote if the first positive number exists return index + 1 else return
     *           index of valid elements to 1
     * @param arr
     * @param size
     * @return
     */
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        // Your code here
        // swap and get number of positive elements
        int k = swapAllValidNumbers(arr);

        // if positive exists replace as invalid
        for(int i = 0; i < k; i++) {
            int currValue = Math.abs(arr[i]) - 1;
            if(currValue < k && arr[currValue] > 0) {
                arr[currValue] = -arr[currValue];
            }
        }

        for(int i = 0; i < k; i++) {
            if(arr[i] > 0) return i + 1;
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int N = 5,
                arr[] = { 1, 2, 3, 4, 5 };
        missingNumber(arr, N);
    }
}
