package DSA.Graph;

import java.util.ArrayList;

public class DetectaCycle {
    public boolean DFS(int V, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[V] = true;
        for (int s : adj.get(V)) {
            if (!visited[s]) {
                if (DFS(s, V, adj, visited)) {
                    return true;
                }
            } else if (parent != s) {
                return true;
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && DFS(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5, E = 5,
        adj[][] = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < adj.length; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < adj[i].length; j++) {
                list.get(i).add(adj[i][j]);
            }
        }

        new DetectaCycle().isCycle(V, list);
    }
}
