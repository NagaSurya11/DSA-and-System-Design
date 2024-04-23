public class Palindrome {
    public static boolean solution(int x) {
        int temp = x;
        int y = 0;
        while (temp > 0) {
            y = (y * 10) + temp % 10;
            temp /= 10;
        }
        return x == y;
    }
    public static void main(String[] args) {
        System.out.println(solution(121));
    }
}
