package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/11/20 15:32
 */
public class Hot494 {

    public static void main(String[] args) {

        int[] nums = {100};
        int target = -200;
        System.out.println(findTargetSumWays2(nums, target));
    }

    static int count = 0;

    /**
     * 法一、回溯
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, target, 0);
        return count;
    }

    /**
     * 回溯
     *
     * @param nums
     * @param curr
     * @param target
     * @param sum
     */
    private static void backtrack(int[] nums, int curr, int target, int sum) {
        if (curr == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        backtrack(nums, curr + 1, target, sum + nums[curr]);
        backtrack(nums, curr + 1, target, sum - nums[curr]);
    }

    /**
     * 法二、消除重叠子问题，将计算过的数存储下来，防止重复计算
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, target);
    }

    static Map<String, Integer> memo = new HashMap<>();

    /**
     * 返回组成rest的组合数量
     *
     * @param nums
     * @param i
     * @param rest
     * @return
     */
    private static int dp(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + "," + rest;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        memo.put(key, result);
        return result;
    }

    /**
     * 法三、动态规划
     * dp[i][j]=dp[i-1][j]+dp[i-1][j-num[i-1]]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //这两种情况不符合合法的子集划分
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        return subsets1(nums, (sum + target) / 2);
    }

    /**
     * 计算nums中有几个子集的和为sum
     * 可理解为背包问题：背包中有nums这么多物品，每个物品的重量为nums[i]，每个物品只能用一次，请问有几种不同的方法可以恰好装满这个背包
     * dp[i][j]=x表示为，若只在前i个物品中选择，若当前背包的容量为j,则最多有x种方法可以恰好装满背包
     * dp[i][j]的状态转移如下：
     * 1、不把第i个物品装入背包，则恰好装满背包的的方法数取决于上一个状态dp[i-1][j]
     * 2、把第i个物品装入背包，则只要看前i-1个物品有几种方法可以装满j-nums[i-1]即可，所以取决于dp[i-1][j-nums[i-1]]
     *
     * @param nums
     * @param sum
     * @return
     */
    private static int subsets(int[] nums, int sum) {
        //计算nums中有几个子集的和为sum,dp[i][j]=x表示前i个物品中,背包的容量为j,最多有x种方法可以恰好装满背包
        int n = nums.length;
        System.out.println("n:" + n + "   sum:" + sum);
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            //容量为0,什么都不装，唯一的一种装法
            dp[i][0] = 1;
        }
        //遍历物品
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                //等于装和不装nums[i-1]物品的和
                if (j >= nums[i - 1]) {
                    //不装   装
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    //背包的空间不足，只能选择不装物品i
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }

    /**
     * 空间压缩后的计算nums中有几个子集的和为sum
     * jitou:ldh278647941  18877367499
     * tt19534158847
     * A18878113724
     * AA15977333084
     * wm1212520123456789
     *
     *
     * @param nums
     * @param sum
     * @return
     */
    private static int subsets1(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[sum];
    }
}
