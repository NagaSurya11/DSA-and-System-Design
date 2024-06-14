package DSA.DisJointSet;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind();
        int[] parent = new int[6];
        int[] rank = new int[6];
        for(int i = 1; i <= 5; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        unionFind.union(1, 2, parent, rank);
        unionFind.union(1, 5, parent, rank);
        System.out.println(unionFind.isConnected(1, 5, parent, rank));
    }
}
