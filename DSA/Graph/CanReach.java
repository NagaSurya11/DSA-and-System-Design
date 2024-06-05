package DSA.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class CanReach {
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
     * @implNote A value of cell 1 means Source.
     * @implNote A value of cell 2 means Destination.
     * @implNote A value of cell 3 means Blank cell.
     * @implNote A value of cell 0 means Wall.
     */
    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        // Code here
        Pair source = null;
        int n = grid.length;
        int m = grid[0].length;

        for(int i  = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    source = new Pair(i, j);
                    break;
                }
            }
            if(source != null) {
                break;
            }
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(source);

        int[] row = {0, -1, 0, 1}, column = {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for(int i = 0 ; i < 4; i++) {
                int x = pair.i + row[i];
                int y = pair.j + column[i];
                if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != 0) {
                    if(grid[x][y] == 2) {
                        return true;
                    }else if(grid[x][y] == 3) {
                        grid[x][y] = 1;
                        queue.add(new Pair(x, y));
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,3,0,0},{3,0,0,0,3}
        ,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
        new CanReach().is_Possible(grid);
    }
}
