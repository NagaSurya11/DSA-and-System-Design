package DSA.Stack;

/**
 * CelebrityProblem
 */
public class CelebrityProblem {

    // Function to find if there is a celebrity in the party or not.
    // here you need to find all j except current is 1 and all i except current is 0
    int celebrity(int M[][], int n) {
        // code here
        int i = 0, j = n - 1;
        while (i < j) {
            if (M[j][i] == 1) {
                j--;
            } else {
                i++;
            }
        }
        int celebrity = i;
        for (int x = 0; x < n; x++) {
            if(x != celebrity) {
                if (M[x][celebrity] == 0 || M[celebrity][x] == 1) {
                    return -1;
                }
            }
        }
        return celebrity;
    }

    public static void main(String[] args) {
        int N = 2,
                M[][] = { { 0, 1 },
                        { 1, 0 } };
        System.out.println(new CelebrityProblem().celebrity(M, N));
    }
}