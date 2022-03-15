package main.java.weekcompetition.week271;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/12 10:48
 */
public class LeetCode5953 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, -2, -3, 4, 1};
        System.out.println(subArrayRanges1(nums));
    }

    /**
     * 法二
     *
     * @param nums
     * @return
     */
    public static long subArrayRanges1(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum = sum + max - min;
            }
        }
        return sum;
    }

    /**
     * 法一、先产生数组的全部子数组，然后再求符合条件的子数组之和
     *
     * @param nums
     * @return
     */
    public static long subArrayRanges(int[] nums) {
        List<List<Integer>> subList = subsets(nums);
        long res = 0;
        for (int i = 0; i < subList.size(); i++) {
            if (subList.get(i).size() > 1) {
                res = res + subSetsRes(subList.get(i));
            }
        }
        return res;
    }

    private static long subSetsRes(List<Integer> nums) {
        int max = nums.get(0), min = nums.get(0);
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i < nums.length - len + 1; i++) {
                List<Integer> list = new LinkedList<>();
                for (int k = i; k < i + len; k++) {
                    list.add(nums[k]);
                }
                result.add(list);
            }
        }
        return result;
    }
}
