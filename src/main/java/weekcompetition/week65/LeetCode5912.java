package main.java.weekcompetition.week65;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/11/13 22:43
 */
public class LeetCode5912 {


    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},
                {3, 2},
                {2, 4},
                {5, 6},
                {3, 5}
        };
        int[] qu = {1, 2, 3, 4, 5, 6};
        int[] res = maximumBeauty(nums, qu);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        List<int[]> item = new ArrayList<>(items.length);
        for (int i = 0; i < items.length; i++) {
            item.add(items[i]);
        }
        Collections.sort(item, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < item.size(); j++) {
                int[] num = item.get(j);
                if (num[0] <= queries[i]) {
                    max = Math.max(max, num[1]);
                } else if (num[0] > queries[i]) {
                    break;
                }
            }
            res[i] = max;
        }
        return res;
    }
}
