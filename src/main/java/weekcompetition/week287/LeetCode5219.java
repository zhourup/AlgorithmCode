package main.java.weekcompetition.week287;

/**
 * @author zhourup
 * @date 2022/4/3 10:55
 */
public class LeetCode5219 {

    public static void main(String[] args) {
        int[] nums = {5, 8, 6};
        long k = 3;
        System.out.println(maximumCandies(nums, k));
    }

    /**
     * 法一、会超时
     * 先计算所有数的总和，计算理想情况下sum/k能每个孩子分到的糖果数
     * 再遍历sum/k到0
     *
     * @param candies
     * @param k
     * @return
     */
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int ca : candies) {
            sum += ca;
        }
        if (sum < k) {
            return 0;
        }
        if (sum == k) {
            return 1;
        }
        long max = (int) (sum / k);

        for (long i = max; i >= 0; i--) {
            int count = 0;
            for (int ca : candies) {
                count += ca / i;
            }
            if (count >= k) {
                return (int) i;
            }
        }
        return 0;
    }

    /**
     * 法二、二分法
     *
     * @param candies
     * @param k
     * @return
     */
    public static int maximumCandies1(int[] candies, long k) {
        long sum = 0;
        for (int ca : candies) {
            sum += ca;
        }
        if (sum < k) {
            return 0;
        }
        if (sum == k) {
            return 1;
        }
        //用来存放非满足条件的最大值
        long res = 0;
        long max = sum / k;
        long l = 1, r = max;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long count = 0;
            for (int num : candies) {
                count += num / mid;
            }
            if (count >= k) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) res;
    }
}
