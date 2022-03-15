package main.java.array;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2022/1/1 13:35
 */
public class LeetCode503 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int[] res = nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 循环数组：常用的套路是将数组长度翻倍，但是不用构造新数组，而是利用循环数组的技巧来模拟数组长度翻倍的效果
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
