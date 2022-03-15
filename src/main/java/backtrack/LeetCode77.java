package main.java.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        List<Integer> temp = new ArrayList<>(k);
        dfs(1, k, n, res, temp);
        return res;
    }

    /**
     * 法一：回溯
     *
     * @param index
     * @param k
     * @param n
     * @param result
     * @param temp
     */
    private static void backtracking(int index, int k, int n, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backtracking(i + 1, k, n, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 法二：选或者不选
     *
     * @param index
     * @param k
     * @param n
     * @param result
     * @param temp
     */
    private static void dfs(int index, int k, int n, List<List<Integer>> result, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (index > n - k + 1) {
            return;
        }
        dfs(index + 1, k, n, result, temp);
        temp.add(index);
        dfs(index + 1, k - 1, n, result, temp);
        temp.remove(temp.size() - 1);
    }
}
