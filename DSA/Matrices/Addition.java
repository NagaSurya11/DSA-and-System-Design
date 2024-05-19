package DSA.Matrices;

public class Addition {
    public static int[][] add(int A[][], int B[][]) {
        if (A.length == 0 || B.length == 0 || A.length != B.length || A[0].length != B[0].length) {
            return new int[0][];
        }
        int result[][] = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A[][] = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }
        };
        int B[][] = {
                { 1, 3 },
                { 3, 2 },
                { 3, 3 },
        };

        int sum[][] = add(A, B);
    }
}
