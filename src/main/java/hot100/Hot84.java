package main.java.hot100;

import java.util.Arrays;
import java.util.Stack;

public class Hot84 {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea2(heights));
    }

    /**
     * 法一、暴力，遍历每个高度的柱状，向左延伸，找到大于等于当前柱形高度最左边元素的下标，向右延伸找到大于等于当前柱形高度的最右边元素下标
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        int len = heights.length;
        int[] arr = new int[len + 2];
        for (int i = 0; i < len; i++) {
            arr[i + 1] = heights[i];
        }
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i, right = i;
            while (left >= 0 && arr[left] >= arr[i]) {
                left--;
            }
            while (right < arr.length && arr[right] >= arr[i]) {
                right++;
            }
            res = Math.max((right - left - 1) * arr[i], res);
        }
        return res;
    }

    /**
     * 法二、单调栈+两轮遍历
     * 1、首先从左往右对数组进行遍历，借助单调栈求出每根柱子的左边界
     * 2、随后从右往左对数组进行遍历，借助单调栈求出每根柱子的右边界
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

    /**
     * 法三、单调栈+一轮遍历
     * <p>
     * 当对位置i进行出栈时可以确定它的右边界
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
