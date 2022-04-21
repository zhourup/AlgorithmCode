package main.java.others;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2022/4/21 16:21
 */
public class LeetCode1288 {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 4},
                {3, 6},
                {2, 8},
        };
        System.out.println(removeCoveredIntervals(nums));
    }

    /**
     * 思路：先计算被覆盖区间数，然后总数减去其即为结果
     * 返回删除区间操作后，剩余区间的数目
     * [a,b]和[c,d]当c>=a&&d<==b，即[c,d]是在[a,b]里面的，所以[c,d]可被删除
     *
     * @param intervals
     * @return
     */
    public static int removeCoveredIntervals(int[][] intervals) {
        //思路：先按照第一个元素排序，再排第二个遍历每个元素
        int n = intervals.length;
        boolean[] isConvert = new boolean[n];
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < n; i++) {
            if (isConvert[i]) {
                continue;
            }
            int[] a = intervals[i];
            for (int j = i + 1; j < n; j++) {
                if (isConvert[j]) {
                    continue;
                }
                int[] b = intervals[j];
                if (a[1] >= b[1]) {
                    isConvert[j] = true;
                }
                if (a[0] == b[0] && a[1] <= b[1]) {
                    isConvert[i] = true;
                }
            }
        }
        int covertCount = 0;
        for (boolean b : isConvert) {
            if (b) {
                covertCount++;
            }
        }
        return n - covertCount;
    }

    /**
     * 法二
     *
     * @param intervals
     * @return
     */
    public static int removeCoveredIntervals1(int[][] intervals) {
        //按照起点升序排序，起点相同则降序排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (left <= curr[0] && right >= curr[1]) {
                count++;
            }
            if (right >= curr[0] && right <= curr[1]) {
                right = curr[1];
            }
            if (right < curr[0]) {
                left = curr[0];
                right = curr[1];
            }
        }
        return intervals.length - count;
    }
}
