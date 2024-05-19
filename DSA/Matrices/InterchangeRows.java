package DSA.Matrices;

public class InterchangeRows {
    // Function to interchange the rows of a matrix.
    static void interchangeRows(int matrix[][]) {
        // code here
        int low = 0;
        int high = matrix.length - 1;

        while (low < high) {
            for (int i = 0; i < matrix[low].length; i++) {
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;
            }
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 },
                { 13, 14, 15 } };
        interchangeRows(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
