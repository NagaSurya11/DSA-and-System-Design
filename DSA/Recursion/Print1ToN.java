package DSA.Recursion;

public class Print1ToN {
    public void printNos(int x, int N) {
        if (x > N) {
            return;
        }

        System.out.print(x + " ");
        printNos(x + 1, N);
    }

    public void printNos(int N) {
        // Your code here
        printNos(1, N);
    }
}
