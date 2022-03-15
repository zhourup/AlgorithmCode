package main.java.stack;

import java.util.Stack;

public class LeetCode1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates1(s));
    }

    public static String removeDuplicates(String S) {
        Stack<Character> result = new Stack<Character>();
        result.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (!result.empty()) {
                char temp = result.peek();
                if (S.charAt(i) == temp) {
                    result.pop();
                } else {
                    result.push(S.charAt(i));
                }
            } else {
                result.push(S.charAt(i));
            }
        }
        return result.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    }

    public static String removeDuplicates1(String S) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (char c : S.toCharArray()) {
            if (len != 0 && c == sb.charAt(len - 1)) {
                sb.deleteCharAt(len - 1);
                len--;
            } else {
                sb.append(c);
                len++;
            }
        }
        return sb.toString();
    }
}
