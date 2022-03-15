package main.java.weekcompetition.week67;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/11 22:51
 */
public class LeetCode5935 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int time = 0;
        System.out.println(goodDaysToRobBank1(nums, time));
    }

    public static List<Integer> goodDaysToRobBank1(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //求每个数左边连续大于或等于当前数的数量
        for (int i = 1; i < n; i++) {
            left[i] = (security[i] <= security[i - 1]) ? left[i - 1] + 1 : 0;
        }
        //求每个数右边连续大于或等于当前数的数量
        for (int i = n - 2; i >= 0; i--) {
            right[i] = (security[i] <= security[i + 1]) ? right[i + 1] + 1 : 0;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 法一、超时了。。
     *
     * @param security
     * @param time
     * @return
     */
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int left = time, right = n - time - 1;
        for (int i = left; i <= right; i++) {
            if (security[i - time] >= security[i] && security[i + time] >= security[i]) {
                if (isGoodDay(security, i, time)) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    /**
     * 判断当前天之前和之后天都大于现在
     *
     * @param nums
     * @param index
     * @param time
     * @return
     */
    private static boolean isGoodDay(int[] nums, int index, int time) {
        for (int i = index; i < index + time; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        for (int i = index; i > index - time; i--) {
            if (nums[i - 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
