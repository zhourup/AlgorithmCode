package main.java.weekcompetition.week286;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/3/27 14:06
 */
public class LeetCode5269 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(100);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(8);
        list2.add(9);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        System.out.println(maxValueOfCoins(lists, 2));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> pile = piles.get(i - 1);
            int max = Math.min(k, pile.size());
            int[] sum = new int[max + 1];
            sum[0] = 0;
            for (int j = 1; j <= max; j++) {
                sum[j] = sum[j - 1] + pile.get(j - 1);
            }

            for (int j = 1; j <= k; j++) {
                for (int l = 0; l <= Math.min(j, pile.size()); l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - l] + sum[l]);
                }
            }
        }
        return dp[n][k];
    }
}
