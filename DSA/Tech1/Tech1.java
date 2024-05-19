package DSA.Tech1;

import java.util.Stack;

public class Tech1 {
    static int swapAllPositive(int arr[], int n) {
        int curr_idx = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] > 0) {
                // swap
                int temp = arr[i];
                arr[i] = arr[curr_idx];
                arr[curr_idx++] = temp;
            }
        }
        return curr_idx + 1;
    }
    static int missingNumber(int arr[], int size) {
        // Buketting Technique
        int k = swapAllPositive(arr, size);
        for(int i = 0; i < k; i++) {
            int curr_value = Math.abs(arr[i]) - 1;
            if(curr_value < k && arr[curr_value] > 0) {
                arr[curr_value] = -arr[curr_value];
            }
        }
        for(int i = 0; i < k; i++) {
            if(arr[i] > 0) return i + 1;
        }
        return k;
    }
    static int smallestSubstring(String s) {
        // int result = s.length();
        // // naive approach
        // for(int i = 0; i < s.length(); i++) {
        //     String subString = s.charAt(i) + "";
        //     for(int j = i + 1; j < s.length(); j++) {
        //         subString += s.charAt(j);
        //         if(subString.contains("0") && subString.contains("1") && subString.contains("2")) {
        //             result = Math.min(result, subString.length());
        //         }
        //     }
        // }

        // sliding window technique
        int result = s.length();
        int counter[] = new int[3];
        int i = 0, j = 0;
        while (j < s.length()) {
            counter[s.charAt(j) - '0']++;
            while (counter[0] > 0 && counter[1] > 0 && counter[2] > 0) {
                counter[s.charAt(i) - '0']--;
                result = Math.min(result, j - i + 1);
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(smallestSubstring("10110212"));
        System.out.println(missingNumber(new int[]{-11, 0, 1, 2, -12}, 5));
        Stack<Character> st = new Stack<Character>();
        st.push('a');
        st.push('a');
        st.push('a');
        System.out.println(st.toString());
    }
}
