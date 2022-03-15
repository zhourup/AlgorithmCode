package main.java.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode268 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(missingNumber1(nums));
    }

    /**
     * 方法一
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];
        for (int i = 0; i < len; i++)
            temp[i] = 0;

        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0)
                return i;
        }
        return 0;
    }

    /**
     * 方法二：排序后再判断
     *
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    /**
     * 方法三：哈希表
     *
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);
        int ex = nums.length + 1;
        for (int i = 0; i < ex; i++) {
            if (!numSet.contains(i))
                return i;
        }
        return -1;
    }

}
