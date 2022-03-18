package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/18 23:43
 */
public class Sword21 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = exchange(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static int[] exchange(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
