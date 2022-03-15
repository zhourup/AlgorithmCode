package main.java.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hot128 {

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive1(nums));
    }

    /**
     * 法一、先排序，再计数发O(NlogN)
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i] != nums[i - 1]) {
                    count = 0;
                } else {
                    count--;
                }
            }
            count++;
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    /**
     * 法二、哈希表 O(N)
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currMax = 1;
                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currMax += 1;
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }
}
