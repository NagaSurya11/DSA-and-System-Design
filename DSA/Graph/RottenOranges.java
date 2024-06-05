package DSA.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    /**
     * Pair
     */
    public class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /**
     *  0 : Empty cell
        1 : Cells have fresh oranges
        2 : Cells have rotten oranges
     */
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        // Code here
        Queue<Pair> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int visited_length = 0; // it is used to check whether all mangoes are rotten if some are not rot reachable it will be less
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    visited_length++;
                    grid[i][j] = Integer.MAX_VALUE;
                }else if(grid[i][j] == 0) { // no need to proceed if empty
                    visited[i][j] = true;
                    visited_length++;
                }
            }
        }

        int row[] = {-1, 1, 0, 0}, column[] = {0, 0, -1, 1};
        int res = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = pair.i + row[i];
                int y = pair.j + column[i];
                int distance = (grid[pair.i][pair.j]) == Integer.MAX_VALUE ? 0 : grid[pair.i][pair.j];

                if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid[x][y] != 0) {
                    int temp = distance + 1;
                    res = Math.max(res, temp);
                    grid[x][y] = temp;
                    visited[x][y] = true;
                    visited_length++;
                    queue.add(new Pair(x, y));
                }
            }
        }
        return visited_length != m * n ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 2, 0, 1}
        };
        new RottenOranges().orangesRotting(grid);
    }
}
