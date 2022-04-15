package main.java.math;

import java.util.Random;

/**
 * @author zhourup
 * @date 2022/4/15 14:55
 */
public class LeetCode398 {

    class Solution {

        int[] arr;
        Random r = new Random();

        public Solution(int[] nums) {
            arr = nums;
        }

        public int pick(int target) {
            int i = 0, res = 0;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] == target) {
                    i++;
                    if (0 == r.nextInt(i)) {
                        res = k;
                    }
                }
            }
            return res;
        }
    }
}
