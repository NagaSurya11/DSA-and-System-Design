package DSA.Matrices;

import java.util.ArrayList;
import java.util.List;

public class SumOfUpperAndLowerTriangularMartix {
    // Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
        // code here
        int upperSum = 0;
        int lowerSum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    upperSum += matrix[i][j];
                    lowerSum += matrix[i][j];
                }else if (i < j){
                    upperSum += matrix[i][j];
                }else {
                    lowerSum += matrix[i][j];
                }
            }
        }
        return new ArrayList<>(List.of(upperSum, lowerSum));
    }

    public static void main(String[] args) {
        int N = 3,
        mat[][] = {{6, 5, 4},
                   {1, 2, 5},
                   {7, 9, 7}};
        sumTriangles(mat, N).forEach(i -> {
            System.out.print(i + " ");
        });
    }
}
