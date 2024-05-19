package DSA.Matrices;

public class Multiplication {
    static int[][] multiplyMatrix(int A[][], int B[][]) {
        // code here
        if (A.length == 0 || B.length == 0 || A[0].length != B.length) {
            return new int[0][];
        }
        int r1 = A.length, c2 = B[0].length, r2 = B.length;
        int result[][] = new int[r1][B[0].length];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < r2; k++) {
                    result[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A[][] = {{35, 1}, {70, 25}, {79, 59}, {63, 65}, {6, 46}, {82, 28}, {62, 92} },

            B[][] = {{43, 28, 37, 92, 5, 3, 54}, {93, 83, 22, 17, 19, 96, 48}};

        multiplyMatrix(A, B);
    }
}
