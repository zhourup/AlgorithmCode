package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/26 22:43
 */
public class Hot300 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 4};
        System.out.println(lengthOfLIS1(nums));
    }

    /**
     * 法一、动态规划，时间复杂度O(N^2)，空间复杂度O(N)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            int cur = i - 1;
            while (cur >= 0) {
                if (nums[i] > nums[cur]) {
                    dp[i] = Math.max(dp[i], dp[cur] + 1);
                }
                cur--;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 法二、贪心+二分查找
     * <p>
     * 设当前已求出的最长上升子序列的长度为len(初始化为1)，从前往后遍历数组nums,在遍历到nums[i]时
     * 如果nums[i]>d[len]，则直接加入d数组末尾，并更新len=len+1
     * 否则在d数组追踪进行二分查找，找出第一个比nums[i]小的数d[k]，并更新d[k+1]=nums[i]
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        int len = 1, n = nums.length;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                //找到第一个小于num[i]的数d[k]，并将d[k+1]的数置为nums[i]
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (nums[i] > d[mid]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
