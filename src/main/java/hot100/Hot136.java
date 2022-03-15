package main.java.hot100;

import java.util.Arrays;

public class Hot136 {

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber1(nums));
    }


    /**
     * 法一、排序再判断
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count--;
            }
            if (count == -1) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 法二、使用位运算的异或运算
     * 1、任何数和0做异或运算仍然是原来的数
     * 2、任何数和其自身做异或运算都是0
     * 3、异或运算满足交换律和结合律
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
