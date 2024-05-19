package DSA.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationOfPostfix {
    public static int evaluationOfPostfix(String equation) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < equation.length(); i++) {
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
        System.out.println(evaluationOfPostfix("123+*8-"));
    }
}
