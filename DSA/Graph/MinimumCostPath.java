package DSA.Graph;

import java.util.ArrayList;

public class MinimumCostPath {
    public class Vertex {
        int cost;
        int v;
        Vertex(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public void addAdjacencyLink(ArrayList<ArrayList<Vertex>> adj, int row, int column) {
        int[] rows = {0, -1, 0, 1}, columns = {-1, 0, 1, 0};
        for(int i = 0; i < 4; i++) {
            int x = row + rows[i];
            int y = column + columns[i];

            
        }
    }
    public ArrayList<ArrayList<Vertex>> getAdj(int[][] grid, int n, int m) {
        ArrayList<ArrayList<Vertex>> adj = new ArrayList<>();
        int source = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                adj.add(new ArrayList<>());

            }
        }
        return adj;
    }
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int source = 0;
        int destination = n * m - 1;
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,4},{3,7}};
        new MinimumCostPath().minimumCostPath(grid);
    }
}
