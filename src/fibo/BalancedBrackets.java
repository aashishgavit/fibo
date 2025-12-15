package fibo;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String s = "{[()]}";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) {
                    System.out.println("Not Balanced");
                    return;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    System.out.println("Not Balanced");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Balanced" : "Not Balanced");
    }
}