package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * not satisfied need to revisit
 */
public class AriculationPoint {

    final int NIL = -1;
    int disc_time;

    public void APUtil(int u, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, int[] parent, boolean[] visited,
            boolean[] ap) {
        visited[u] = true;
        disc[u] = low[u] = ++disc_time;
        int children = 0;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, adj, disc, low, parent, visited, ap);

                low[u] = Math.min(low[u], low[v]);

                // if root and not has parent node edge
                if (parent[u] == NIL && children > 1) {
                    ap[u] = true;
                } else if (parent[u] != NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Function to return Breadth First Traversal of given graph.
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // ArrayList<Integer> apList = new ArrayList<>();
        disc_time = 0;
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];
        Arrays.fill(parent, NIL);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                APUtil(i, adj, disc, low, parent, visited, ap);
            }
        }
        int totalAps = 0;
        for(int i = 0; i < V; i++) {
            if(ap[i]) totalAps++;
        }
        if(totalAps == 0) {
            return new int[]{-1};
        }else {
            int[] result = new int[totalAps];
            int idx = 0;
            for(int i = 0; i < V; i++) {
                if(ap[i]) result[idx++] = i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {{0, 1}, {1, 4}, {2, 4}, {3, 4}, {2, 3}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        new AriculationPoint().articulationPoints(V, adj);
    }
}
