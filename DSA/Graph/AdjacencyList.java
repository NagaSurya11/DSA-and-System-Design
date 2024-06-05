package DSA.Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public void addAdjacencyLink(ArrayList<ArrayList<Integer>> list, int vIdx, int eIdx) {
        list.get(vIdx).add(eIdx);
        // list.get(eIdx).add(vIdx);
    }
    ArrayList<ArrayList<Integer>> printGraph(int V, int edges[][], ArrayList<ArrayList<Integer>> list) {
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            addAdjacencyLink(list, edges[i][0], edges[i][1]);
        }
        return list;
    }

    AdjacencyList(int V, int edges[][],  ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            addAdjacencyLink(adj, edges[i][0], edges[i][1]);
        }
    }

    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,4},{4,1},{4,3},{1,3},{1,2},{3,2}};
        int V = 5;
    }
}
