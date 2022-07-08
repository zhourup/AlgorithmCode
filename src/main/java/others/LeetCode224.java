package others;

import java.util.Stack;

/**
 * 小米298:yyq13915025509
 *
 */
public class LeetCode224 {

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    /**
     * 求解s的值
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        return helper(s);
    }

    static int index;
    private static int helper(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == 'c') {
                num = helper(s.substring(1));
            }
            if ((!isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c==')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
