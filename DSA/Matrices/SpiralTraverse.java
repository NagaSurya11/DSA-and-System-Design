package DSA.Matrices;

import java.util.ArrayList;

public class SpiralTraverse {
    // Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int bottom, int right) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0;
        int left = 0;
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                list.add(matrix[i][right - 1]);
            }
            right--;
            if(top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom - 1][i]);
                }
                bottom--;
            }
            if(left < right) {
                for (int i = bottom - 1; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int r = 3, c = 4,
                matrix[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 } };
        spirallyTraverse(matrix, r, c).forEach(i -> {
            System.out.print(i + " ");
        });
        ;
    }
}
