package main.java.array;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2022/1/4 20:38
 */
public class LeetCode316 {

    public static void main(String[] args) {
        String s = "acdb";
        System.out.println(removeDuplicateLetters(s));
    }

    /**
     * 去重算法：去除字符串中重复的字母，使得每个字母只出现一次，返回结果的字典序最小
     * 要求一、去重
     * 要求二、去重字符串中的字符顺序不能打乱
     * 要求三、字典序最小
     * <p>
     * 如果当前字符a比之前的字符字典序小，就有可能需要把前面的字符pop出来，让a排在前面
     * 在stack.peek()>c时要分两种情况
     * 1、如果stack.peek()这个字符之后还会出现，可以将它pop()
     * 2、如果stack.peek()这个字符后面不会再出现了。不应该pop()
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        //记录字符串中每个字符的数量，因为输入的是ASCII字符
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
