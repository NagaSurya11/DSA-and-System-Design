package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridges {
    static int disc_time;
    static final int NIL = -1;
    static boolean DFSUtil(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] disc, int[] low, int[] parent, int c,
            int d) {
        visited[u] = true;
        low[u] = disc[u] = ++disc_time;

        for(int v: adj.get(u)) {
            if(!visited[v]) {
                parent[v] = u;
                if(DFSUtil(v, adj, visited, disc, low, parent, c, d)) {
                    return true;
                }
                low[u] = Math.min(low[u], low[v]);

                if(((c == u && d == v) || c == v && d == u) && low[v] > disc[u]) {
                    return true;
                }
            }else if(v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        return false;
    }

    // Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,
            int c, int d) {
        // code here
        disc_time = 0;
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        Arrays.fill(parent, NIL);

        for(int i = 0; i < V; i++) {
            if(!visited[i] && DFSUtil(i, adj, visited, disc, low, parent, c, d)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int V = 29;
        int edges[][] = {{6, 21}, {17, 12}, {2, 11}, {9, 11}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        isBridge(V, adj, 17, 12);

        new AriculationPoint().articulationPoints(V, adj);
    }
}
