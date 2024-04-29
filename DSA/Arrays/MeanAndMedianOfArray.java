package DSA.Arrays;

import java.util.Arrays;

public class MeanAndMedianOfArray {
    //Function to find median of the array elements.
    public int median(int A[],int N)
    {
       Arrays.sort(A);
       //Your code here
       //If median is fraction then conver it to integer and return
       return (N % 2 == 0) ? A[(N / 2) - 1] : A[N / 2];
    }
    public int mean(int A[],int N)
    {
       //Your code here
       int total = A[0];
       for(int i = 1; i < N; i++) {
        total += A[i];
       }
       return total / N;
    }
}
