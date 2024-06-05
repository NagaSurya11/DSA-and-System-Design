package DSA.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestElementFromCell {
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
        //Function to find distance of nearest 1 in the grid for each cell.
        public int[][] nearest(int[][] grid)
        {
            // Code here
            Queue<Pair> queue = new ArrayDeque<>();

            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] != 0) {
                        queue.add(new Pair(i, j));
                        grid[i][j] = 0;
                    }else {
                        grid[i][j] = -1; // to change
                    }
                }
            }

            int row[] = {-1, 1, 0, 0};
            int column[] = {0, 0, -1, 1};

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int x = pair.i + row[i];
                    int y = pair.j + column[i];
                    int distance = grid[pair.i][pair.j];
                    if(x >= 0 && x < grid.length &&
                        y >= 0 && y < grid[0].length &&
                        grid[x][y] == -1 ) {
                            grid[x][y] = distance + 1;
                            queue.add(new Pair(x, y));
                        }
                }
            }

            return grid;
        }

        public static void main(String[] args) {
            int [][] grid = {{1,0,1},{1,1,0},{1,0,0}};
            /**
             * 1 0 1
             * 1 1 0
             * 1 0 0
             */

            new NearestElementFromCell().nearest(grid);
        }
}
