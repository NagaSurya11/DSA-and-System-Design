package DSA.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumber {
    // Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N) {
        // Your code here
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        if (N == 0)
            return list;
        int count = 0;
        queue.add("1");
        while (count < N) {
            String curr_value = queue.poll();
            list.add(curr_value);
            count++;
            if (count < N) {
                queue.add(curr_value + "0");
            }
            if (count + 1 < N) {
                queue.add(curr_value + "1");
            }
        }
        return list;
    }
}
