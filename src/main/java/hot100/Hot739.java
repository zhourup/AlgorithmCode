package main.java.hot100;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2021/11/9 21:55
 */
public class Hot739 {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures1(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 法一
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (temperatures[i] < max) {
                res[i] = getIndex(temperatures, i);
            } else {
                res[i] = 0;
            }
            max = Math.max(max, temperatures[i]);
        }
        return res;
    }

    private static int getIndex(int[] temperatures, int curr) {
        for (int i = curr + 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[curr]) {
                return i - curr;
            }
        }
        return 0;
    }

    /**
     * 法二、单调栈
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
