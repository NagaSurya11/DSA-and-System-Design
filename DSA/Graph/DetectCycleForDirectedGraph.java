package DSA.Graph;

import java.util.ArrayList;

public class DetectCycleForDirectedGraph {
    /**
     * DFS
     */
    // boolean DFS(ArrayList<ArrayList<Integer>> adj, int V, boolean[] visited, boolean[] recursiveStack) {
    //     visited[V] = true;
    //     recursiveStack[V] = true;

    //     for(int vertex : adj.get(V)) {
    //         if(!visited[vertex] && DFS(adj, vertex, visited, recursiveStack)) {
    //             return true;
    //         }else if(recursiveStack[vertex]) {
    //             return true;
    //         }
    //     }

    //     recursiveStack[V] = false;
    //     return false;
    // }

    // // Function to detect cycle in a directed graph.
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // code here
    //     boolean[] visited = new boolean[V];
    //     boolean[] recursiveStack = new boolean[V];
    //     for(int i = 0; i < V; i++) {
    //         if(!visited[i] && DFS(adj, i, visited, recursiveStack)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

}
