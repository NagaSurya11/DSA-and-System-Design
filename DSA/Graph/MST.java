package DSA.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    /**
     * Pair
     */
    public static class Pair {
        int weight;
        int element;
        Pair(int element, int weight) {
            this.element = element;
            this.weight = weight;
        }
    }
    /**
     * @implNote min heap is built based on weight of each edge
     * @implNote if already visited no need to add to heap another time
     * @param V
     * @param E
     * @param adj
     * @return
     */
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        Comparator<Pair> comparator = (o1, o2) -> Integer.compare(o1.weight, o2.weight);
        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);
        queue.add(new Pair(0, 0));
        int minCost = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(!visited[pair.element]) {
                visited[pair.element] = true;
                minCost += pair.weight;
                adj.get(pair.element).forEach(pArr -> {
                    if(!visited[pArr[0]]) {
                        queue.add(new Pair(pArr[0], pArr[1]));
                    }
                });
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        List<List<int[]>> adj = new ArrayList<>();
        int V = 3;
        int E = 3;
        int grid[][] = {
            {0, 1, 5},
            {1, 2, 3},
            {0, 2, 1}
        };
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for(int j = 0; j < E; j++) {
                adj.get(i).add(new int[]{j, grid[i][j]});
            }
        }
        spanningTree(V, E, adj);
    }
}
