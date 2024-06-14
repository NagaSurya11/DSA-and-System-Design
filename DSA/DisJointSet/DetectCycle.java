package DSA.DisJointSet;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectCycle {
    public int find(int a, int[] parent) {
        if(a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a], parent);
        return parent[a];
    }
    public void union(int a, int b, int[] parent, int[] rank) {
        int aroot = find(a, parent);
        int broot = find(b, parent);
        if(aroot == broot) return;
        if(rank[aroot] < rank[broot]) {
            parent[broot] = aroot;
        }else if(rank[broot] < rank[aroot]) {
            parent[aroot] = parent[broot];
        }else {
            parent[broot] = aroot;
            rank[aroot]++;
        }
    }
        //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int n = adj.size();
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                int y = adj.get(i).get(j);
                if(i < y) {
                    int xroot = find(i, parent);
                    int yroot = find(y, parent);
                    if(xroot == yroot) return 1;
                    union(i, y, parent, rank);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {{0, 2}, {0, 3}, {0, 4}, {1, 3}, {2, 4}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println(new DetectCycle().detectCycle(v, adj));
    }
}
