package DSA.DisJointSet;

public class UnionFind {
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

    public boolean isConnected(int a, int b, int[] parent, int rank[]) {
        return find(a, parent) == find(b, parent);
    }
}
