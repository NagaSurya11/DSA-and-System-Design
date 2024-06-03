package DSA.Graph;

import java.util.Queue;
import java.util.ArrayDeque;

public class StepsByKnight {
    // Function to find out minimum steps Knight needs to reach target position.
    /**
     * Pair
     */
    public class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Code here
        if(KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
            return 0;
        }
        int[][] board = new int[N][N];
        Queue<Pair> queue = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        Pair startPosition = new Pair(KnightPos[0] - 1, KnightPos[1] - 1);
        queue.add(startPosition);

        int[] row = {-1, -1, 1, 1, -2, 2, -2, 2}, column = {-2, 2, -2, 2, -1, -1, 1, 1};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int distance = board[pair.i][pair.j];
            for(int i = 0; i < 8; i++) {
                int x = pair.i + row[i];
                int y = pair.j + column[i];
                if(x >= 0 && y >= 0 && x < N && y < N
                    && (x != startPosition.i || y != startPosition.j)
                    && (board[x][y] == 0 || board[x][y] > distance + 1)) {
                        board[x][y] = distance + 1;
                        if(x == TargetPos[0] - 1 && y == TargetPos[1] - 1) {
                            result = Math.min(result, board[x][y]);
                        }else {
                            queue.add(new Pair(x, y));
                        }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int N=3,
        knightPos[] = {3, 1},
        targetPos[] = {1, 3};

        /**
         * 0 1 0
         * 0 0 2
         * 0 0 0
         */
        new StepsByKnight().minStepToReachTarget(knightPos, targetPos, N);
    }
}
