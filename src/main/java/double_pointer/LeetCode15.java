package main.java.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/8 23:18
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //避免第一个数选择相同
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * 返回从下标为start开始，和为target的两个数，不能重复
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    private static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int l = start, r = n - 1;
        while (l < r) {
            int left = nums[l], right = nums[r];
            int sum = left + right;
            if (sum < target) {
                while (l < r && nums[l] == left) {
                    l++;
                }
            } else if (sum > target) {
                while (l < r && nums[r] == right) {
                    r--;
                }
            } else {
                List<Integer> list = new ArrayList<>(3);
                list.add(left);
                list.add(right);
                res.add(list);
                while (l < r && nums[l] == left) {
                    l++;
                }
                while (l < r && nums[r] == right) {
                    r--;
                }
            }
        }
        return res;
    }
}
