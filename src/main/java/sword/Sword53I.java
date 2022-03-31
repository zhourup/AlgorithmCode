package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 16:11
 */
public class Sword53I {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                count++;
                //往左找
                int index = mid - 1;
                while (index >= 0 && nums[index] == target) {
                    count++;
                    index--;
                }
                //往右找
                index = mid + 1;
                while (index < nums.length && nums[index] == target) {
                    count++;
                    index++;
                }
                return count;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return count;
    }
}
