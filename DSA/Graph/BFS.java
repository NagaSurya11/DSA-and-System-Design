package DSA.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * directed graph
 */
public class BFS {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[V];
            queue.add(0);
            visited[0] = true;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                list.add(u);
                adj.get(u).forEach(vertex -> {
                    if(!visited[vertex]) {
                        visited[vertex] = true;
                        queue.add(vertex);
                    }
                });
            }
            return list;
        }
        public static void main(String[] args) {
            int V = 5, E = 4;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(List.of(1, 2, 3)));
            list.add(new ArrayList<>());
            list.add(new ArrayList<>(List.of(4)));
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());

            new BFS().bfsOfGraph(V, list);
        }
}
