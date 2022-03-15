package main.java.hot100;

import java.util.LinkedList;

/**
 * @author zhourup
 * @date 2021/10/20 12:54
 */
public class Hot239 {

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;
        int[] res = maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 法一、双端队列
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 队列按从大到小排序
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 将当前索引存入队列
            queue.addLast(i);
            // 判断当前队首索引是否移出
            if (i - k >= queue.peek()) {
                queue.poll();
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }

    /**
     * 时间会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        if (k >= nums.length) {
            for (Integer num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return new int[]{max};
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int left = 0, right = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            right = i;
        }
        for (int i = 0; i < len; i++) {
            res[i] = max;
            ++left;
            ++right;
            if (left < len && nums[left - 1] == max) {
                max = getMax(nums, left, right);
            }
            if (left < len && nums[right] > max) {
                max = Math.max(max, nums[right]);
            }
        }
        return res;
    }

    private static int getMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
