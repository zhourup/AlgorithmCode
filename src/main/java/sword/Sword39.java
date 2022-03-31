package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 16:01
 */
public class Sword39 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 9, 9, 10};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int tmp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                tmp = nums[i];
                count = 1;
                continue;
            }
            if (nums[i] == tmp) {
                count++;
            } else {
                count--;
            }
        }
        return tmp;
    }
}
