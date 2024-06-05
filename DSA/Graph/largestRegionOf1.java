package DSA.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class largestRegionOf1 {
    int count;
    /**
     * Pair
     */
    public class Pair {
        int row;
        int column;
        Pair (int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    public boolean isSafe(int n, int m, int row, int column, boolean[][] visited) {
        return (row >= 0 && column >= 0 && row < n && column < m && !visited[row][column]);
    }

    public void DFSUtil(int[][] grid, int n, int m, int row, int column, boolean[][] visited) {
        count++;
        visited[row][column] = true;
        int[] rows = {-1, -1, -1, 0, 0, 1, 1, 1},
        columns = {-1, 0, 1, -1, 1, -1, 0, 1}; // anti clock wise
        for(int i = 0; i < 8; i++) {
            int x = row + rows[i];
            int y = column + columns[i];
            if(isSafe(n, m, x, y, visited)) {
                DFSUtil(grid, n, m, x, y, visited);
            }
        }
    }
    // Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            for(int  j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Pair(i, j));
                }else {
                    visited[i][j] = true; // mark all 0 as visited
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(!visited[pair.row][pair.column]) {
                count = 0;
                DFSUtil(grid, n, m, pair.row, pair.column, visited);
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
        new largestRegionOf1().findMaxArea(grid);
    }
}
