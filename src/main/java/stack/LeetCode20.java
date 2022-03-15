package main.java.stack;

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    /**
     * 法一
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else {
                if (isSymmetry(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }

        }
        return stack.isEmpty();
    }

    public static boolean isSymmetry(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'))
            return true;
        else
            return false;
    }

    /**
     * 法二
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
