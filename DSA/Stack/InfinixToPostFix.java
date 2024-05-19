package DSA.Stack;

import java.util.Stack;

public class InfinixToPostFix {
    public static int precedence(char c) {
        return c == '+' || c == '-' ? 1
            : c == '*' || c == '/' ? 2
            : c == '^' ? 3 : -1;
    }
    public static String convert(String S) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(Character.isLetterOrDigit(S.charAt(i))) {
                result += S.charAt(i);
            }else if(S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            }else if(S.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && precedence(S.charAt(i)) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(S.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        // String s = "A+B*C+D";
        String s = "((A+B))-C*(D/E)+F";
        System.out.println(convert(s));
    }
}
