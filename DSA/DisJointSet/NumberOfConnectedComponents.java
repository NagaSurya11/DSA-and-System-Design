package DSA.DisJointSet;

import java.util.HashSet;

public class NumberOfConnectedComponents {
    static int find(int x, int parent[]) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    // Function to merge two nodes a and b.
    static void unionNodes(int a, int b, int parent[], int rank[], int n) {
        // add your code
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

    // Function to determine number of connected components.
    static int findNumberOfConnectedComponents(int n, int parent[], int rank[]) {
        // add your code
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            set.add(find(i, parent));
        }
        return set.size();
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 2;
        int parent[] = new int[v + 1];
        int rank[] = new int[v + 1];

        for(int i = 1; i <= v; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        unionNodes(1, 3, parent, rank, v);
        unionNodes(1, 5, parent, rank, v);
        System.out.println(findNumberOfConnectedComponents(v, parent, rank));
    }
}
