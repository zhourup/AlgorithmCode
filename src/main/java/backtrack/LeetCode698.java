package main.java.backtrack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zhourup
 * @date 2022/4/2 23:19
 */
public class LeetCode698 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    /**
     * 法一、每一个数字遍历到各个桶去
     * 超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = temp;
        }
        //记录每个桶的数字之和
        int[] bucket = new int[k];
        //理论上每个桶数字之和
        int target = sum / k;
        return backtrack(nums, 0, bucket, target);
    }

    private static boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            //检查所有桶的数字之和是否都是target
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }
        //穷举nums[index]可能要装入的桶
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            //撤销选择
            bucket[i] -= nums[index];
        }
        return false;
    }

    /**
     * 法二、以桶的视角，每个桶要遍历nums中所有的数字
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean canPartitionKSubsets1(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return backtrack1(k, 0, nums, 0, used, target);
    }

    /**
     * 需要遍历nums中的所有数字，决定哪些数字需要装到当前桶中
     *
     * @param k      k号桶
     * @param bucket k号桶数字之和
     * @param nums   全部数字
     * @param start  当前元素下标
     * @param used   标记是否装入桶中
     * @param target 目标和
     * @return
     */
    private static boolean backtrack1(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0) {
            //所有桶都装满了
            return true;
        }
        if (bucket == target) {
            //装满当前桶，递归装下一个桶
            return backtrack1(k - 1, 0, nums, 0, used, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            }
            bucket += nums[i];
            used[i] = true;
            //递归穷举下一个数是否装入当前桶
            if (backtrack1(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            bucket -= nums[i];
            used[i] = false;
        }
        return false;
    }
}
