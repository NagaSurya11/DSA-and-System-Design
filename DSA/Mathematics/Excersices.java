import java.util.ArrayList;
import java.util.List;

public class Excersices {
    /**
     * @link https://www.geeksforgeeks.org/batch/interview-101-9/track/DSASP-Mathematics/problem/absolute-value
     * @param I
     * @return
     */
    public int absolute(int I) {
        // code here
        return (I < 0) ? -1 * I : I;
    }

    /**
     * @link https://www.geeksforgeeks.org/batch/interview-101-9/track/DSASP-Mathematics/problem/convert-celsius-to-fahrenheit
     * @param C
     * @return
     */
    public double cToF(int C) {
        // Your code here
        double result = (C * 9 / 5) + 32;
        return result;
    }

    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        ArrayList<Integer> list= new ArrayList<>();
        if((b * b) < (4 * a * c)) {
            System.out.print("Imaginary");
            return list;
        }
        double bSquareminus4ac = Math.sqrt(Math.abs((b * b) - (4 * a * c)));
        int x = (int) Math.floor(((-b) + bSquareminus4ac) / (2 * a));
        int y = (int) Math.floor(((-b) - bSquareminus4ac) / (2 * a));
        if(x < y) {
            list.add(0, y);
            list.add(1, x);
        }else {
            list.add(0, x);
            list.add(1, y);
        }
        return list;
    }

    public static void main(String[] args) {
        Excersices excersices = new Excersices();
        excersices.quadraticRoots(543, 199, 843);
    }
}
