package DSA.Greedy;

public class LargestNumberWithSum {
    // static StringBuffer largestNumber(int n) {
    // StringBuffer sb = new StringBuffer("");
    // for(int i = 0; i < n; i++) {
    // sb.append("9");
    // }
    // return sb;

    // }
    // static int sumOfDigits(String s) {
    // int result = 0;
    // for (char c : s.toCharArray()) {
    // result += Character.getNumericValue(c);
    // }
    // return result;
    // }
    // //Function to return the largest possible number of n digits
    // //with sum equal to given sum.
    // static String largestNumber(int n, int sum)
    // {
    // // add your code here
    // StringBuffer current = largestNumber(n);
    // int currentSum = sumOfDigits(current.toString());
    // if(currentSum < sum) {
    // return "-1";
    // }
    // int idx = current.length() - 1;
    // while (idx >= 0 && currentSum > sum) {
    // if(currentSum - 9 > sum) {
    // current.setCharAt(idx, '0');
    // currentSum -= 9;
    // idx--;
    // } else if (currentSum - 1 >= sum) {
    // int lastDigit = Character.getNumericValue(current.charAt(idx));
    // lastDigit--;
    // current.setCharAt(idx, (char) (lastDigit + '0'));
    // if(lastDigit == 0) {
    // idx--;
    // }
    // currentSum--;
    // }
    // }
    // return current.toString();
    // }

    // Function to return the largest possible number of n digits
    // with sum equal to given sum.
    static String largestNumber(int n, int sum) {
        // maximum achievable sum is 9*n. if given sum is
        // greater than that, we return -1.
        if (sum > 9 * n) {
            return "-1";
        }
        String str = "";
        for (int i = 0; i < n; i++) {
            int temp = 0;
            if (sum != 0)
                // if sum>9 we store 9 in temp as digit or we store the sum.
                temp = sum > 9 ? 9 : sum;

            // storing the number in temp as character in final string.
            str += (char) (temp + '0');
            // updating the sum.
            sum -= temp;
        }
        // returning the final string.
        return str;
    }

    public static void main(String[] args) {
        largestNumber(5, 12);
    }
}
