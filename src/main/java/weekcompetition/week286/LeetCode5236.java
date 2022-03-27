package main.java.weekcompetition.week286;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhourup
 * @date 2022/3/27 10:41
 */
public class LeetCode5236 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 5};
        System.out.println(minDeletion(nums));
    }

    public static int minDeletion(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] == nums[i - 1]) {
                count++;
                i--;
            }
        }
        return count + (nums.length - count) % 2;
    }

    public static int minDeletion1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Deque<Integer> q = new LinkedList<>();
        q.push(nums[0]);
        for (int i = 1; i < n; i++) {
            //当栈大小为偶数时，说明此时可以将数据直接加到栈中
            if (q.size() % 2 == 0) {
                q.push(nums[i]);
            } else {
                //当为奇数时，要判断与栈顶元素是否相同，相同则不能添加
                int val = q.peek();
                if (nums[i] == val) {
                    continue;
                }
                q.push(nums[i]);
            }
        }
        if (q.size() % 2 == 0) {
            return n - q.size();
        }
        //当栈大小为奇数时，需要减去栈顶元素
        return n - q.size() + 1;
    }
}
