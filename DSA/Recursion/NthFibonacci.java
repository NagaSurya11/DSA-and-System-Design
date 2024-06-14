package DSA.Recursion;

public class NthFibonacci {
    static int fibonacci(int x, int y, int n) {
        if (n == 1) {
            return x + y;
        }

        return fibonacci(y, x + y, n - 1);
    }

    static int fibonacci(int n) {
        // your code here
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(1, 1, n - 2);
        }
    }
}
