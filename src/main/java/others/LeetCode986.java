package main.java.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/4/21 20:40
 */
public class LeetCode986 {

    public static void main(String[] args) {
        int[][] nums1 = {
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25},
        };
        int[][] nums2 = {
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26},
        };
        int[][] res = intervalIntersection(nums1, nums2);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            int a1 = firstList[p1][0], a2 = firstList[p1][1];
            int b1 = secondList[p2][0], b2 = secondList[p2][1];
            //两个区间有交集
            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }

            if (a2 > b2) {
                p2++;
            } else {
                p1++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
