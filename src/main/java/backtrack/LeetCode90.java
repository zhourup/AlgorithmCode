package main.java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/4/5 21:57
 */
public class LeetCode90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * 我们需要进行剪枝，如果一个节点有多条值相同的树枝相邻，则只遍历第一条，剩下的都剪掉，不要去遍历
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        //每一个节点的值都是一个子集
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            //剪枝逻辑，i>start是很重要的细节之处
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
