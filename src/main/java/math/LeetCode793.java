package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/14 15:05
 */
public class LeetCode793 {

    public static void main(String[] args) {
        int k = 0;
        System.out.println(preimageSizeFZF(k));
    }

    /**
     * 给定一个k，有多少个n，使得n!结果末尾有k个0
     * 思路：在区间[0,LONG_MAX]中寻找满足trailingZeroes(n)==K的左侧边界和右侧边界
     *
     * @param k
     * @return
     */
    public static int preimageSizeFZF(int k) {
        return (int) (right_bound(k) - left_bound(k) + 1);
    }

    private static long left_bound(int k) {
        long l = 0, r = Long.MAX_VALUE;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (trailingZeroes(mid) > k) {
                r = mid - 1;
            } else if (trailingZeroes(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private static long right_bound(int k) {
        long l = 0, r = Long.MAX_VALUE;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (trailingZeroes(mid) > k) {
                r = mid - 1;
            } else if (trailingZeroes(mid) < k) {
                l = mid + 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 返回n!的结果末尾0的个数
     *
     * @param n
     * @return
     */
    private static long trailingZeroes(long n) {
        long res = 0;
        long div = 5;
        while (div <= n) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
