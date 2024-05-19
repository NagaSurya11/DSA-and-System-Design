package DSA.Matrices;

public class ExchangeMatrixColumns {
    // Function to exchange first column of a matrix with its last column.
    static void exchangeColumns(int matrix[][]) {
        // code here
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][0];
            matrix[i][0] = matrix[i][matrix[i].length - 1];
            matrix[i][matrix[i].length - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int n1 = 4, m1 = 4,
                matrix[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };
        exchangeColumns(matrix);
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < m1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
