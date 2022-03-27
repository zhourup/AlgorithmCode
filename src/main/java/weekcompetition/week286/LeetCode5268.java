package main.java.weekcompetition.week286;

/**
 * @author zhourup
 * @date 2022/3/27 10:31
 */
public class LeetCode5268 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 99};
        long[] res = kthPalindrome(nums, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long min = (long) Math.pow(10, (intLength - 2 + 1) / 2);
        long max = (long) (9 * Math.pow(10, (intLength - 1) / 2));
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            //如果当前数q大于范围内的，则为-1
            int q = queries[i];
            if (q > max) {
                res[i] = -1;
                continue;
            }
            long cur = q - 1 + min;
            String str = String.valueOf(cur);
            if (intLength % 2 == 0) {
                StringBuilder sb = new StringBuilder(str);
                str += sb.reverse().toString();
            } else {
                StringBuilder sb = new StringBuilder(str);
                str += sb.reverse().toString().substring(1);
            }
            res[i] = Long.parseLong(str);
        }
        return res;
    }
}
