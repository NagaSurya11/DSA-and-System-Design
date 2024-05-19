package DSA.Matrices;

public class ReversingColumnsOfMatrix {
    // Function to reverse the columns of a matrix.
    static void reverseCol(int matrix[][]) {
        // code here
        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = matrix[i].length - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low++] = matrix[i][high];
                matrix[i][high--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 11, 10, 9 },
                { 13, 14, 15 } };
        reverseCol(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
