package main.java.weekcompetition.week272;

/**
 * @author zhourup
 * @date 2021/12/19 10:45
 */
public class LeetCode5958 {

    public static void main(String[] args) {
        int[] prices = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7};
        System.out.println(getDescentPeriods(prices));
    }

    public static long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = n;
        int left = 0, index = 0;
        while (index < n) {
            while (index + 1 < n && prices[index + 1] - prices[index] == -1) {
                index++;
            }
            if (index - left >= 1) {
                res = res + getNum(left, index);
            }
            index++;
            left = index;
        }

        return res;
    }

    /**
     * 求得以下标从l到r可以有多少个平滑下降的数量，减去长度为1的数量
     *
     * @param l
     * @param r
     * @return
     */
    private static long getNum(int l, int r) {
        int n = r - l + 1;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res - n;
    }

}
