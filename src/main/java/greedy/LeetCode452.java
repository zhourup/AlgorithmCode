package main.java.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/3/28 14:43
 */
public class LeetCode452 {

    public static void main(String[] args) {
        int[][] points = {
                {-2147483646, -2147483645},
                {2147483646, 2147483647},
        };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            }
            return 0;
        });
        List<int[]> tmp = new ArrayList<>();
        int count = 0;
        tmp.add(points[0]);
        for (int i = 1; i < points.length; i++) {
            int[] pre = tmp.get(tmp.size() - 1);
            int[] curr = points[i];
            if (pre[1] >= curr[0]) {
                count++;
                continue;
            } else {
                tmp.add(curr);
            }
        }
        return points.length - count;
    }
}
