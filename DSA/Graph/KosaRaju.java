package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosaRaju {
    public void DFSUtil(int V, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {
        visited[V] = true;
        adj.get(V).forEach(vertex -> {
            if (!visited[vertex]) {
                DFSUtil(vertex, adj, visited);
            }
        });
    }

    public ArrayList<ArrayList<Integer>> transporse(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> adjTransporse = new ArrayList<>();
        adj.forEach((list) -> {
            adjTransporse.add(new ArrayList<>());
        });

        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                adjTransporse.get(j).add(i);
            }
        }
        return adjTransporse;
    }

    public void fillStack(int V, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, Stack<Integer> stack) {
        visited[V] = true;
        adj.get(V).forEach(vertex -> {
            if (!visited[vertex]) {
                fillStack(vertex, adj, visited, stack);
            }
        });
        stack.push(V);
    }

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // step 1 fill stack in decreasing order of visited number

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillStack(i, adj, visited, stack);
            }
        }

        // step 2 transporse of graph
        ArrayList<ArrayList<Integer>> adjTransporse = transporse(adj);

        // step 3 by order of stack by step one apply dfs for each which are not visited
        // using transporse of adj

        // make all as not visited
        Arrays.fill(visited, false);

        int SCCs = 0;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                DFSUtil(vertex, adjTransporse, visited);
                SCCs++;
            }
        }

        return SCCs;
    }

}
