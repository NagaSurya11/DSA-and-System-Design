package DSA.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopoSort {
    // needs to be printed once all the dependent is printed
        //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] topoOrder = new int[V];

        int[] inDegree = new int[V];

        adj.forEach(list -> {
            list.forEach(vertex -> inDegree[vertex]++);
        });

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topoOrder[index++] = vertex;

            adj.get(vertex).forEach(u -> {
                if(--inDegree[u] == 0) {
                    queue.add(u);
                }
            });
        }
        return topoOrder;
    }

    public static void main(String[] args) {
        
    }
}
