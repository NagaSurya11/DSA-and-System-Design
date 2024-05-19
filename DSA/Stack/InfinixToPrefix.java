package DSA.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfinixToPrefix {
    public static int precedence(char c) {
        return c == '^' ? 1:
        c == '*' || c == '/' ? 2 :
        c == '+' || c == '-' ? 3 : -1;
    }
    public static String infinixToPrefix(String equation) {
        String result = "";
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = equation.length() - 1; i >= 0; i--) {
            char c = equation.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                result = c + result;
            }else if(c == ')') {
                stack.push(')');
            }else if(c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result = stack.pop() + result;
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && precedence(stack.peek()) < precedence(c)) {
                    result = stack.pop() + result;
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(infinixToPrefix("x+y*z/w+u"));
    }
}
