package main.java.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhourup
 * @date 2021/10/24 10:20
 */
public class Hot287 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(findDuplicate1(nums));

    }

    /**
     * 法一、使用哈希表
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return num;
            }
        }
        return nums[0];
    }

    /**
     * 法二、快慢指针
     *
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        int p1 = nums[0];
        int p2 = nums[p1];
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        }
        int pre1 = 0;
        int pre2 = p1;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
