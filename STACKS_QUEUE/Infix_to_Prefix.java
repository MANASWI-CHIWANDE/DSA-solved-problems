package com.company.stackAndQueue;

import java.util.Stack;

public class Infix_to_Prefix {
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String exp) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                answer += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // Unbalanced parentheses
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    answer += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Unbalanced parentheses
            }
            answer += stack.pop();
        }

        return reverseString(answer);
    }

    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "(x+y)*z/(w+u)";
        String prefixExpression = Infix_to_Prefix.infixToPrefix(infixExpression);
        System.out.println("Prefix expression: " + prefixExpression);
    }
}
