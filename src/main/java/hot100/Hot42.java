package main.java.hot100;

import java.util.Stack;

public class Hot42 {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap3(height));

    }

    /**
     * 法一、暴力
     * 1、初始化ans=0
     * 2、从左到右遍历height
     * 初始化left_max=0，right_max=0
     * 从height[0]到当前位置寻找最大值left_max=Max(height[j],left_max)
     * 从当前位置到height末端寻找最大值right_max=max(height[j],right_max)
     * ans=ans+min(left_max,right_max)-height[i]
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int left_max = 0;
            for (int j = 0; j <= i; j++) {
                if (height[j] > left_max) {
                    left_max = height[j];
                }
            }
            int right_max = 0;
            for (int j = i; j < height.length; j++) {
                if (height[j] > right_max) {
                    right_max = height[j];
                }
            }
            res = res + Math.min(left_max, right_max) - height[i];
        }
        return res;
    }

    /**
     * 法二、动态规划，O(N)和O(N)
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int res = 0;
        int[] lHeight = new int[height.length];
        int[] rHeight = new int[height.length];
        int left_max = 0, right_max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > left_max) {
                left_max = height[i];
            }
            lHeight[i] = left_max;
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > right_max) {
                right_max = height[i];
            }
            rHeight[i] = right_max;
        }
        for (int i = 0; i < height.length; i++) {
            res = res + Math.min(lHeight[i], rHeight[i]) - height[i];
        }
        return res;
    }

    /**
     * 法三、单调栈
     * 栈用来跟踪可能储水的最长条形块
     * 如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
     * 如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和前一个条形块界定，因此我们可以弹出栈顶元素并累加到ans
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                res += currWidth * currHeight;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 法四、双指针
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res = res + leftMax - height[left];
                left++;
            } else {
                res = res + rightMax - height[right];
                right--;
            }
        }
        return res;
    }

}
