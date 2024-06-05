package DSA.Graph;

public class NooFIslands {

    public void DFS(char[][] grid, boolean[][] visited, int row, int column, int n, int m) {
        visited[row][column] = true;
        int[] rows = {-1, -1, -1, 0, 0, 1, 1, 1},
        columns = {-1, 0, 1, -1, 1, -1, 0, 1}; // anti clock wise
        for(int i = 0; i < 8; i++) {
            int x = row + rows[i];
            int y = column + columns[i];

            if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1' && !visited[x][y]) {
                DFS(grid, visited, x, y, n, m);
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int  j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    DFS(grid, visited, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char grid[][] = {
            {'1', '0', '0' ,'0' ,'0' ,'1' ,'0' ,'0' ,'0', '1'},
            {'1', '0', '1', '1' ,'1', '1' ,'1' ,'0' ,'0', '1'},
            {'1', '1', '1', '1', '1', '0', '0', '0', '1', '0'},
            {'1', '1', '1', '0', '1', '0', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0', '0', '0', '1', '0', '0'},
            {'0', '0' ,'0', '0', '0' ,'1' ,'1', '1', '1' ,'0'},
            {'0', '0', '1', '1', '0', '0', '0' ,'1' ,'0', '0'}
        };

        new NooFIslands().numIslands(grid);
    }
}
