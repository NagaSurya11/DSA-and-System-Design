package DSA.Matrices;

public class SearchInSortedRowAndColumn {
    // Function to search a given number in row-column sorted matrix.
    static boolean search(int matrix[][], int n, int m, int x) {
        // code here
        int curr_index = 0;
        while (m - 1 >= 0 && curr_index < n) {
            if (x == matrix[curr_index][m - 1]) {
                return true;
            } else if (x < matrix[curr_index][m - 1]) {
                m--;
            } else {
                curr_index++;
            }
        }
        return false;
    }
}
