package main.java.hot100;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2021/11/9 20:23
 */
public class Hot394 {

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
        System.out.println();
    }

    /**
     * 法一、栈
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                // 1、先获取[]内的内容，即字符串content
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String content = sb.toString();

                // 2、删除[，然后获取数字count
                stack.pop();
                StringBuilder numSb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numSb.insert(0, stack.pop());
                }
                String countStr = numSb.toString();
                int count = Integer.parseInt(countStr);

                // 3、将数量count的content插入到栈中
                while (count > 0) {
                    for (char ch : content.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
