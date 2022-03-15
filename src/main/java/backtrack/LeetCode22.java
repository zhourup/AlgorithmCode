package main.java.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> strs = generateParenthesis1(3);
        for (String s : strs) {
            System.out.println(s);
        }
    }

    /**
     * 法一：回溯
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }

    public static void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }

    /**
     * 值得学习的方法
     * 法二：将回溯问题抽象成树形结构遍历问题
     * 深度优先遍历+剪枝
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private static void dfs(int n, String path, List<String> res, int open, int close) {
        if (open > n || close > open) return;
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }

        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }

}
