/**
 * LCM
 * @implNote Formula = x * y  = GDC(x, y) * LCM(x, y)
 * @implNote LCM(x, y) = x * y / GCD(x, y)
 */
public class LCM {
    public static int solution(int a, int b) {
        return (a * b) / GCD.solution(a, b);
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 6));
    }
}
