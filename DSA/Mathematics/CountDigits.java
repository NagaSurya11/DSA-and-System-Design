/**
 * CountDigits
 */
public class CountDigits {
    public static int solution(int x) {
        int count = 0;
        while (x > 0) {
            x = x / 10;
            count++;
        }
        return count;
    }
}