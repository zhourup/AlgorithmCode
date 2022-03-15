package main.java.hot100;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2021/11/13 14:57
 */
public class Hot581 {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray1(nums));
    }

    /**
     * 法一、对原数组进行排序，然后从左到右，从右到左分别找第一个不相同的数。时间复杂度O(NlogN)
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int left = 0, right = len - 1;
        for (left = 0; left < len; left++) {
            if (nums[left] != temp[left]) {
                break;
            }
        }
        for (right = len - 1; right > 0; right--) {
            if (nums[right] != temp[right]) {
                break;
            }
        }
        int count = left > right ? 0 : right - left + 1;
        return count;
    }

    /**
     * 法二、时间复杂度O(N)
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < maxn) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (nums[n - i - 1] > minn) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
