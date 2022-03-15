package main.java.weekcompetition.week268;

/**
 * @author zhourup
 * @date 2021/11/21 11:26
 */
public class LeetCode5933 {

    public static void main(String[] args) {
        int k = 5;
        int n = 20;
        System.out.println(kMirror1(k, n));
    }

    /**
     * 法一、耗时久
     *
     * @param k
     * @param n
     * @return
     */
    public static long kMirror(int k, int n) {
        long[] nums = new long[n];
        int index = 0;
        int i = 1;
        while (index < n) {
            String tenStr = String.valueOf(i);
            if (!isPalindromeStr(tenStr)) {
                i++;
            } else {
                String kStr = Long.toString(i, k);
                if (isPalindromeStr(kStr)) {
                    nums[index++] = i;
                }
                i++;
            }
        }
        long res = 0;
        for (long num : nums) {
            res += num;
        }
        return res;
    }

    /**
     * 法二
     *
     * @param k
     * @param n
     * @return
     */
    public static long kMirror1(int k, int n) {
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            if (isPalindromeStr(Long.toString(i, k))) {
                sum += i;
                if (--n == 0) {
                    return sum;
                }
            }
        }
        for (int i = 0; ; i++) {
            for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                if (isPalindromeStr(Long.toString(Long.parseLong("" + j + new StringBuilder("" + j).reverse()), k))) {
                    sum += Long.parseLong("" + j + new StringBuilder("" + j).reverse());
                    if (--n == 0) {
                        return sum;
                    }
                }
            }
            for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                for (int l = 0; l < 10; l++) {
                    if (isPalindromeStr(Long.toString(Long.parseLong("" + j + l + new StringBuilder("" + j).reverse()), k))) {
                        sum += Long.parseLong("" + j + l + new StringBuilder("" + j).reverse());
                        if (--n == 0) {
                            return sum;
                        }
                    }
                }
            }
        }
    }

    private static boolean isPalindromeStr(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
