package DSA.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PossiblePathsBetweenTwoVertices {
    /**
     * TC - V! (V factorial)
     * @param V
     * @param adj
     * @param source
     * @param destination
     * @return
     */
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int V,
            ArrayList<ArrayList<Integer>> adj, int source,
            int destination) {
        int result = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(current == destination) {
                result ++;
            }else {
                adj.get(current).forEach(vertex -> {
                    queue.add(vertex);
                });
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = 11;
        int edges[][] = {
            {2, 7}, {2, 4}, {7, 4}, {2, 1}, {7, 1}, {4, 1}, {2, 10}, {7, 10},
            {4, 5}, {1, 5}, {10, 5}, {4, 8}, {10, 8}, {5, 8}, {5, 0}, {8, 0}, {1, 6},
            {4, 3}, {8, 3}, {0, 3}, {6, 3}, {2, 9}, {7, 9}, {3, 9}
        };
        new AdjacencyList().printGraph(V, edges, list);
        int source = 7;
        int destination = 6;
        new PossiblePathsBetweenTwoVertices().countPaths(V, list, source, destination);
    }
}
