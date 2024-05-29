package DSA.Backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    public static void fun(int r, int c, int[][] m, int n, String s, ArrayList<String> list) {
        if (r == n - 1 && c == n - 1) {
            list.add(s);
            return;
        }
        m[r][c] = -1;

        if (r - 1 >= 0 && m[r - 1][c] != -1 && m[r - 1][c] == 1) {
            fun(r - 1, c, m, n, s + "U", list);
        }
        if (c + 1 < n && m[r][c + 1] != -1 && m[r][c + 1] == 1) {
            fun(r, c + 1, m, n, s + "R", list);
        }
        if (r + 1 < n && m[r + 1][c] != -1 && m[r + 1][c] == 1) {
            fun(r + 1, c, m, n, s + "D", list);
        }
        if (c - 1 >= 0 && m[r][c - 1] != -1 && m[r][c - 1] == 1) {
            fun(r, c - 1, m, n, s + "L", list);
        }

        m[r][c] = 1;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        if (m[n - 1][n - 1] == 0 || m[0][0] == 0) {
            return list;
        }
        fun(0, 0, m, n, "", list);
        return list;
    }
}
