package DSA.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOfNode {
    public class Pair {
        int vertex;
        int level;
        Pair(int vertex, int level) {
            this.vertex = vertex;
            this.level = level;
        }
    }
        //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        boolean[] visited = new boolean[V];

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(pair.vertex == X) return pair.level;
            if(!visited[pair.vertex]) {
                visited[pair.vertex] = true;
                for(int vertex: adj.get(pair.vertex)) {
                    if(!visited[vertex]) {
                        if(vertex == X) return pair.level + 1;
                        queue.add(new Pair(vertex, pair.level + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}
