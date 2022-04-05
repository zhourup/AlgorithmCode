package main.java.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/4/5 23:00
 */
public class LeetCode216 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum3(3, 9);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, 1, 0, n, k);

        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int start, int currSum, int n, int k) {
        if (path.size() == k) {
            if (currSum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (currSum + i > n) {
                continue;
            }
            path.add(i);
            backtrack(res, path, i + 1, currSum + i, n, k);
            path.remove(path.size() - 1);
        }
    }
}
