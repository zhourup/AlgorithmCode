package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/19 21:15
 */
public class Hot238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf1(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 法一、时间和空间都是O(N)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /**
     * 法二、时间O(N),空间O(1)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            r *= nums[i];
        }
        return res;
    }

}
