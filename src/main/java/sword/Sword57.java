package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 17:05
 */
public class Sword57 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }
        return new int[0];
    }
}
