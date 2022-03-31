package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 16:21
 */
public class Sword53II {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(missingNumber(nums));
    }

    /**
     * 法一、遍历
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int pre = -1;
        for (int num : nums) {
            if (num != pre + 1) {
                return pre + 1;
            }
            pre = num;
        }
        return pre + 1;
    }

    /**
     * 法二、二分
     *
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
