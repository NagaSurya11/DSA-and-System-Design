package DSA.Matrices;

import java.util.ArrayList;

public class BoundaryTraversal {
    // Function to return list of integers that form the boundary
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[0][i]);
            }
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[i][0]);
            }
        } else {
            for (int i = 0; i < m; i++) {
                result.add(matrix[0][i]);
            }
            for (int i = 1; i < n; i++) {
                result.add(matrix[i][m - 1]);
            }
            for (int i = m - 2; i >= 0; i--) {
                result.add(matrix[n - 1][i]);
            }
            for (int i = n - 2; i >= 1; i--) {
                result.add(matrix[i][0]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4, m = 4,
                matrix[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };
        boundaryTraversal(matrix, n, m).forEach(i -> {
            System.out.print(i + " ");
        });
    }
}
