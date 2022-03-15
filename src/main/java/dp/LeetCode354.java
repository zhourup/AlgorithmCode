package main.java.dp;

import java.util.Arrays;

public class LeetCode354 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        System.out.println(maxEnvelopes(nums));
    }

    /**
     * 最多有多少个信封能放到一起，放的条件：长和宽都得大于
     * <p>
     * 技巧与思路：：先对宽度w进行升序排序，如果w遇到相同的，则按高度h降序排序，再对所有的h的作为一个数组，求其LIS
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        //对高度数组求其LIS
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public static int lengthOfLIS(int[] nums) {
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
