package main.java.array;

/**
 * @author zhourup
 * @date 2022/1/2 21:20
 */
public class LeetCode1109 {

    static class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increasement(int i, int j, int val) {
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
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int n = 5;
        int[] res = corpFlightBookings(nums, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        Difference di = new Difference(diff);
        for (int[] book : bookings) {
            di.increasement(book[0] - 1, book[1] - 1, book[2]);
        }
        return di.result();
    }
}
