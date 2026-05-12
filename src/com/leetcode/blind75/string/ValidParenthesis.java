package com.practice.leetcode.blind75.string;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String str = "()[]{}";
        String str2 = "()[]{(}";

        System.out.println(IsValidParanthesis(str));
        System.out.println(IsValidParanthesis(str2));

        System.out.println(IsValidParanthesisV2(str));
        System.out.println(IsValidParanthesisV2(str2));
    }

    private static boolean IsValidParanthesis(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(')');

            } else if (ch == '{') {
                stack.push('}');

            } else if (ch == '[') {
                stack.push(']');

            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean IsValidParanthesisV2(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
