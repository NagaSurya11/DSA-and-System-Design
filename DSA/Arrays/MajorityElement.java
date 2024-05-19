package DSA.Arrays;

public class MajorityElement {
    /**
     * @implNote moore's voting algorithm
     * @implNote initialize count as 1 and majority as arr[0]
     * @implNote if the next element is majority element count ++ else count --
     * @implNote if count becomes zero set the majority as current element which decreased previous
     * @implNote max occuring element will be as res
     * @implNote check if the freq of res is greater than n / 2 else no one wins
     * @param arr
     * @return
     */
    public static int solution(int arr[]) {
        int res = 0;
        int count = 1;

        // find the majority element
        for(int i = 1; i < arr.length; i++) {
            if(arr[res] == arr[i]) count++;
            else count--;

            if(count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;
        // check if it is majority
        for(int i = 0; i < arr.length; i++) {
            if(arr[res] == arr[i]) count++;
        }

        return count > arr.length / 2 ? arr[res]: -1;
    }

    public static void main(String[] args) {
        int a[] = new int[] { 1, 3, 3, 1, 3 };
        System.out.println(solution(a));
    }
}
