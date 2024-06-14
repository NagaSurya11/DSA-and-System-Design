package DSA.Recursion;

public class TowerOfHanoi {
    // toh(2, 1, 3, 2);
    long result = 0;
    public long toh(int N, int from, int to, int aux) {
        // Your code here
        if(N == 1) {
            result++;
            System.out.println("move disk "+ N +" from rod "+ from +" to rod " + to);
            return result;
        }
        toh(N - 1, from, aux, to);
        result++;
        System.out.println("move disk "+ N +" from rod "+ from +" to rod " + to);
        toh(N - 1, aux, to, from);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TowerOfHanoi().toh(3, 1, 3, 2));
    }
}
