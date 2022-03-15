package main.java.hot100;

import java.util.*;

public class Hot39 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(nums, target).toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, path, candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int remain, int index) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                return;
            }
            path.add(candidates[i]);
            backtrack(res, path, candidates, remain - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
