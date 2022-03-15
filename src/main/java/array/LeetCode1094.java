package main.java.array;

/**
 * @author zhourup
 * @date 2022/1/2 22:52
 */
public class LeetCode1094 {

    static class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = diff[i] + res[i - 1];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        };
        int cap = 5;
        System.out.println(carPooling(nums, cap));

    }

    /**
     * trips[i]代表一组区间操作，旅客的上下车相当于数组的区间加减，关键在于，差分数组的长度设定为多少
     * 题目给了数据取值范围0 <= trips[i][1] < trips[i][2] <= 1000
     *
     * @param trips
     * @param capacity
     * @return
     */
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference di = new Difference(nums);
        for (int[] trip : trips) {
            //乘客在车上的区间是[trip[1],trip[2]-1]
            di.increment(trip[1], trip[2] - 1, trip[0]);
        }

        int[] res = di.result();
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
