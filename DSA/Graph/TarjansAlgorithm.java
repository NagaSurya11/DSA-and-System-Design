package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class TarjansAlgorithm {

    final int NIL = -1;
    int time;

    public void DFSUtil(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
            TreeSet<TreeSet<Integer>> sccList,
            int[] discovery_time,
            int[] lowest_discovery_time, Stack<Integer> stack) {
        lowest_discovery_time[u] = discovery_time[u] = ++time;
        stack.push(u);
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (discovery_time[v] == -1) {
                DFSUtil(v, adj, visited, sccList, discovery_time, lowest_discovery_time, stack);
                lowest_discovery_time[u] = Math.min(lowest_discovery_time[u], lowest_discovery_time[v]);
            } else if (visited[v]) {
                lowest_discovery_time[u] = Math.min(discovery_time[v], lowest_discovery_time[u]);
            }
        }
        int w = NIL;
        if (lowest_discovery_time[u] == discovery_time[u]) {
            TreeSet<Integer> set = new TreeSet<>();
            while (w != u) {
                w = stack.pop();
                set.add(w);
                visited[w] = false;
            }
            sccList.add(set);
        }
    }

    // Function to return a list of lists of integers denoting the members
    // of strongly connected components in the given graph.
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Comparator<Set<Integer>> setComparator = new Comparator<Set<Integer>>() {
            public int compare(Set<Integer> set1, Set<Integer> set2) {
                Iterator<Integer> it1 = set1.iterator();
                Iterator<Integer> it2 = set2.iterator();
                while (it1.hasNext() && it2.hasNext()) {
                    int cmp = it1.next().compareTo(it2.next());
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(set1.size(), set2.size());
            }
        };
        TreeSet<TreeSet<Integer>> sccList = new TreeSet<>(setComparator);
        time = 0;
        boolean[] visited = new boolean[V];
        int[] discovery_time = new int[V];
        int[] lowest_discovery_time = new int[V];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(discovery_time, NIL);
        for (int i = 0; i < V; i++) {
            if (discovery_time[i] == -1) {
                DFSUtil(i, adj, visited, sccList, discovery_time, lowest_discovery_time, stack);
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        sccList.forEach(set -> {
            list.add(new ArrayList<>());
            set.forEach(v -> {
                list.get(list.size() - 1).add(v);
            });
        });
        return list;
    }

    public static void main(String[] args) {
        int V = 8;
        int edges[][] = {
                { 4, 4 }, { 3, 1 }, { 0, 2 }, { 6, 3 }, { 6, 5 }, { 1, 4 }, { 1, 7 }, { 3, 7 }, { 1, 0 }, { 3, 3 },
                { 4, 3 }, { 1, 4 }, { 7, 6 }
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        new TarjansAlgorithm().tarjans(V, adj).forEach(list -> {
            list.forEach(v -> {
                System.out.print(v + " ");
            });
            System.out.println();
        });
    }
}
