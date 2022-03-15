package main.java.dp;

public class LeetCode121 {

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 5, 7};
        System.out.println(maxProfit1(nums));
    }

    /**
     * 暴力查找，时间会超出限制
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 法二：假设计划在第i天卖出股票，那么最大利润的差值一定是在[0,i-1]之间选最低点买入；遍历数组，依次求每个卖出时间的最大差值
     * 再从中取最大差值
     * <p>
     * 只要最低点不是今天，我就可以计算出今天卖出去挣多少
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 法三、动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 法四、动态规划+空间压缩
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int len = prices.length;
        int pre0 = 0, pre1 = 0;
        int curr0 = 0, curr1 = 0;
        for (int i = 0; i < len; i++) {
            if (i - 1 == -1) {
                pre0 = 0;
                pre1 = -prices[i];
                continue;
            }
            curr0 = Math.max(pre0, pre1 + prices[i]);
            curr1 = Math.max(pre1, -prices[i]);
            pre0 = curr0;
            pre1 = curr1;
        }
        return curr0;
    }
}
