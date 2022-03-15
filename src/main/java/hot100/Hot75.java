package main.java.hot100;


public class Hot75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors1(nums);
    }

    /**
     * 法一、单指针
     * 第一轮遍历先将0全部放到数组前面
     * 第二轮遍历将1全部放到0后面
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int tmp = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[index];
                nums[index++] = tmp;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp = nums[i];
                nums[i] = nums[index];
                nums[index++] = tmp;
            }
        }
    }

    /**
     * 法二、双指针
     *
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        int tmp = 0;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1++] = tmp;
            } else if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }
}
