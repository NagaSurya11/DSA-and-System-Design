package DSA.Matrices;

public class Rotate90deg {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) {
        // code here
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low++] = matrix[i][high];
                matrix[i][high--] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int N = 3,
                matrix[][] = { { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 } };
        rotateby90(matrix, N);
    }
}
