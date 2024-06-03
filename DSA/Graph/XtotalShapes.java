package DSA.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class XtotalShapes {
    public class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void DFS(char[][] grid, boolean[][] visited,
        int n, int m, int[] rows, int[] columns, int row, int column) {
            if(!visited[row][column]) {
                visited[row][column] = true;
            }
            for(int i = 0; i < 4; i++) {
                int x = row + rows[i];
                int y = column + columns[i];
                if(x >= 0 && y >= 0 && x < n && y < m
                && !visited[x][y] && grid[x][y] == 'X') {
                    DFS(grid, visited, n, m, rows, columns, x, y);
                }
            }
    }
    // Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 'X') {
                    queue.add(new Pair(i, j));
                }
            }
        }

        int[] row = {0, -1, 0, 1}, column = {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(!visited[pair.i][pair.j]) {
                result++;
                DFS(grid, visited, n, m, row, column, pair.i, pair.j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char grid[][] = {{'X','O','X'},{'O','X','O'},{'X','X','X'}};
        new XtotalShapes().xShape(grid);
    }
}
