package main.java.hot100;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/10/27 21:07
 */
public class Hot301 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String s = ")(";
        System.out.println(removeInvalidParentheses(s));
    }

    /**
     * 法一、回溯+剪枝
     * 删除最小数量的无效括号，使得输入的字符串有效
     *
     * @param s
     * @return
     */
    public static List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        backtrack(s, 0, l, r);
        return res;
    }

    private static void backtrack(String s, int index, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (lremove + rremove > s.length() - i) {
                return;
            }
            if (s.charAt(i) == '(' && lremove > 0) {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, lremove - 1, rremove);
            }
            if (s.charAt(i) == ')' && rremove > 0) {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    /**
     * 法二、BFS
     *
     * @param s
     * @return
     */
    public static List<String> removeInvalidParentheses1(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        boolean flag = false;
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValid(s)) {
                res.add(s);
                flag = true;
            }
            if (flag) {
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

}
