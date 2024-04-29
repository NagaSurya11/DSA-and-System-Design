package DSA.Patterns;

public class Triangle {
    public static void solution(int n) {
        /**
         * n = 5
         * "" "" "" "" * "" "" "" ""
         * "" "" "" *  *  * "" "" ""
         * "" "" *  *  *  *  * "" ""
          */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n * 2; j++) {
                if (j < n - i || j > n + i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution(5);
    }
}
