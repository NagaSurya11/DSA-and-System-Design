package DSA.Graph;

import java.util.ArrayList;

/**
 * Connected
 */
public class DFS {
    public void dfsUtil(int V,
            ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list,
            boolean[] visited) {
        visited[V] = true;
        list.add(V);
        adj.get(V).forEach(i -> {
            if (!visited[i]) {
                dfsUtil(i, adj, list, visited);
            }
        });
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V,
            ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        dfsUtil(0, adj, list, visited);
        return list;
    }
}
