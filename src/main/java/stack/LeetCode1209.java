package main.java.stack;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2022/4/7 23:08
 */
public class LeetCode1209 {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Integer> count = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count.push(1);
            } else {
                int incre = count.pop() + 1;
                if (incre == k) {
                    //删除k个字符
                    sb.delete(i + 1 - k, i + 1);
                    i = i - k;
                } else {
                    count.push(incre);
                }
            }
        }
        return sb.toString();
    }
}
