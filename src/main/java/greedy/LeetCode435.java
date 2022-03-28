package main.java.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/3/28 11:28
 */
public class LeetCode435 {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},
                {2, 3},
        };
        System.out.println(eraseOverlapIntervals(nums));

    }

    /**
     * 贪心
     * 按照结束时间从小到大排序
     * 每次挑选出结束时间最早的区间a,将与区间a重复的区间都去除掉
     * 第一个与a不重复的区间赋为a，继续去除重复区间
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        List<int[]> tmp = new ArrayList<>();
        tmp.add(intervals[0]);
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = tmp.get(tmp.size() - 1);
            int[] curr = intervals[i];
            if (pre[1] > curr[0]) {
                count++;
                continue;
            } else {
                tmp.add(curr);
            }
        }
        return count;
    }
}
