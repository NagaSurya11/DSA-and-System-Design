package DSA.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationOfPrefix {
    public static int evaluationOfPrefix(String equation) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = equation.length() - 1; i >= 0; i--) {
            char c = equation.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result;
                if(c == '+') {
                    result = num1 + num2;
                }else if(c == '-') {
                    result = num1 - num2;
                }else if(c == '*') {
                    result = num1 * num2;
                }else if(c == '/') {
                    result = num1 / num2;
                }else {
                    result = num1 ^ num2;
                }
                stack.push(result);
            }else {
                stack.push(Integer.parseInt(equation.charAt(i) + ""));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(evaluationOfPrefix("+*523"));
    }
}
