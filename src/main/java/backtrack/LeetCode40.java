package main.java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/4/5 22:15
 */
public class LeetCode40 {

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = combinationSum2(nums, 8);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, path, candidates, 0, 0, target);

        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int start, int currSum, int target) {
        if (currSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (currSum + nums[i] > target) {
                continue;
            }
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1, currSum + nums[i], target);
            path.remove(path.size() - 1);
        }
    }
}
