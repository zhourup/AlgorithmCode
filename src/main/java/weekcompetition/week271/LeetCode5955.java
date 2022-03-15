package main.java.weekcompetition.week271;

/**
 * @author zhourup
 * @date 2021/12/13 15:09
 */
public class LeetCode5955 {

    public static void main(String[] args) {
        int[][] fruits = new int[][]{
                {0, 9},
                {4, 1},
                {5, 7},
                {6, 2},
                {7, 4},
                {10, 9}
        };
        int startPos = 5;
        int k = 4;
        System.out.println(maxTotalFruits1(fruits, startPos, k));
    }

    /**
     * 前缀+二分  问题本质：线段[l,r]覆盖了多少水果
     * 线段可能：假设人向左走y步，然后回到起点，再向右走x步，区间长度就是x+2y,区间为[startPos-y,startPos+x]
     * 同理，如果向右走Y步，然后回到起点，再向左走x步，那么区间表示为[startPos-x,start+y]
     * <p>
     * 思路：枚举y长度，然后k-y可以得出x，然后判断每个区间能覆盖的水果有多少，取最大值
     * <p>
     * 法一、这是单纯思路上的实现，但是会超时，需优化
     *
     * @param fruits
     * @param startPos
     * @param k
     * @return
     */
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0;
        for (int x = k; x >= 0; x--) {
            int y = (k - x) / 2;
            int l = startPos - x, r = startPos + y;
            max = Math.max(max, getValue(fruits, l, r));
            int l1 = startPos - y, r1 = startPos + x;
            max = Math.max(max, getValue(fruits, l1, r1));
        }
        return max;
    }

    private static int getValue(int[][] fruits, int left, int right) {
        int sum = 0;
        for (int[] fruit : fruits) {
            if (fruit[0] > right) {
                break;
            }
            if (fruit[0] >= left && fruit[0] <= right) {
                sum += fruit[1];
            }
        }
        return sum;
    }

    public static int maxTotalFruits1(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + fruits[i - 1][1];
        }

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
        }

        int res = 0;
        for (int x = k; x >= 0; x--) {
            int y = (k - x) / 2;
            int l = startPos - x, r = startPos + y;
            int pl = getNumBound(pos, l, 0), pr = getNumBound(pos, r, 1);
            res = Math.max(res, sum[pr + 1] - sum[pl]);

            int l1 = startPos - y, r1 = startPos + x;
            int pl1 = getNumBound(pos, l1, 0), pr1 = getNumBound(pos, r1, 1);
            res = Math.max(res, sum[pr1 + 1] - sum[pl1]);
        }
        return res;
    }


    /**
     * 返回第一个大于target的下标索引
     *
     * @param nums
     * @param target
     * @return
     */
    private static int getNumBound(int[] nums, int target, int flag) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return flag == 0 ? left : right;
    }
}
