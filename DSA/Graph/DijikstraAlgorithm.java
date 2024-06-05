package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * DijikstraAlgorithm
 */
public class DijikstraAlgorithm {
    /**
     * Pair
     */
    public static class Pair {
        int weight;
        int element;

        Pair(int element, int weight) {
            this.element = element;
            this.weight = weight;
        }
    }

    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean fullfilled[] = new boolean[V];
        Comparator<Pair> comparator = (o1, o2) -> Integer.compare(o1.weight, o2.weight);
        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);
        distance[S] = 0;
        queue.add(new Pair(S, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (!fullfilled[pair.element]) {
                fullfilled[pair.element] = true;
                adj.get(pair.element).forEach(pList -> {
                    if (pList.get(0) != S &&
                            distance[pair.element] + pList.get(1) < distance[pList.get(0)]) {
                        distance[pList.get(0)] = distance[pair.element] + pList.get(1);
                        queue.add(new Pair(pList.get(0), distance[pList.get(0)]));
                    }
                });
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int V = 3,
                S = 2;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.get(0).add(new ArrayList<>(List.of(1, 1)));
        adj.get(0).add(new ArrayList<>(List.of(2, 6)));
        adj.get(1).add(new ArrayList<>(List.of(2, 3)));
        adj.get(1).add(new ArrayList<>(List.of(0, 1)));
        adj.get(2).add(new ArrayList<>(List.of(1, 3)));
        adj.get(2).add(new ArrayList<>(List.of(0, 6)));

        dijkstra(V, adj, S);
    }
}