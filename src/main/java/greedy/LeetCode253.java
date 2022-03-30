package main.java.greedy;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2022/3/29 10:48
 */
public class LeetCode253 {

    public static void main(String[] args) {
        int[][] nums = {
                {7, 10},
                {2, 4},
        };
        System.out.println(minMeetingRooms(nums));
    }

    /**
     * 题意：求同一时刻最多有几个区间重叠
     *
     * @param meetings
     * @return
     */
    public static int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int res = 0;
        int count = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
