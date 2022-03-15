package main.java.divide_conquer;

import java.util.HashMap;
import java.util.Map;

public class LeetCode169 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement2(nums));
    }

    /**
     * 法一：哈希表
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 法二：分治
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public static int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 法三：Boyer-Moore投票算法
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
