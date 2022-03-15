package main.java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        Arrays.fill(flags, false);
        dfs(nums, result, temp, flags);
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] flags) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i]) continue;
            temp.add(nums[i]);
            flags[i] = true;
            dfs(nums, result, temp, flags);
            temp.remove(temp.size() - 1);
            flags[i] = false;
        }
    }
}
