package main.java.weekcompetition.week272;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/19 11:21
 */
public class LeetCode5959 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 2, 1, 1, 4, 4, 3, 3, 3, 3, 3};
        int k = 1;
        System.out.println(kIncreasing(arr, k));
    }

    public static int kIncreasing(int[] arr, int k) {
        int ans = 0;
        //每个序列开始的下标i
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            int j = i;
            while (j < arr.length) {
                list.add(arr[j]);
                j += k;
            }
            Integer[] nums = list.toArray(new Integer[list.size()]);
            int temp = lengthOfLIS(nums);
            ans += nums.length - temp;
        }
        return ans;
    }

    /**
     * 最小操作数=数组长度-LIS
     * 求最长递增子序列LIS
     *
     * @param nums
     * @return
     */
    private static int lengthOfLIS(Integer[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                //找到第一个比nums[i]小的数d[k]，并更新d[k+1]=nums[i]
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (d[mid] <= nums[i]) {
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
