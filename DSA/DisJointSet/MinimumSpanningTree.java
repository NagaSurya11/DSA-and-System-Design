package DSA.DisJointSet;

import java.util.ArrayList;
import java.util.Comparator;

public class MinimumSpanningTree {
    /**
     * Edge
     */
    public class Edge{
        int src;
        int des;
        int wt;
        Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

    }
    static int find(int a, int[] parent) {
        if(a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a], parent);
        return parent[a];
    }
    static void union(int a, int b, int[] parent, int[] rank) {
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
        //Function to find the minimum spanning tree value using Kruskal.
    static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        // add your code here
        long res = 0;
        adj.sort((o1, o2) -> Integer.compare(o1.wt, o2.wt));
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0, s = 0; i < m && s < n - 1; i++) {
            Edge edge = adj.get(i);
            int xroot = find(edge.src, parent);
            int yroot = find(edge.des, parent);
            if(xroot != yroot) {
                res += edge.wt;
                union(edge.src, edge.src, parent, rank);
                s++;
            }
        }
        return res;
    }

}
