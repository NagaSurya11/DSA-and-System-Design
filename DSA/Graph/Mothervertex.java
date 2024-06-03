package DSA.Graph;

import java.util.ArrayList;

public class Mothervertex {
    void DFS(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[V] = true;
        for(int vertex : adj.get(V)) {
            if(!visited[vertex]) {
                DFS(vertex, adj, visited);
            }
        }
    }
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        int motherVertex = -1;
        for(int vertex = 0; vertex < V; vertex++) {
            if(!visited[vertex]) {
                DFS(vertex, adj, visited);
                motherVertex = vertex;
            }
        }

        boolean[] check = new boolean[V];
        DFS(motherVertex, adj, check);
        for(boolean val: check) {
            if(!val) return -1;
        }
        return motherVertex;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] adj = {{2, 3}, {0}, {1}, {4}, {}};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < adj.length; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < adj[i].length; j++) {
                list.get(i).add(adj[i][j]);
            }
        }
        new Mothervertex().findMotherVertex(V, list);
    }
}
