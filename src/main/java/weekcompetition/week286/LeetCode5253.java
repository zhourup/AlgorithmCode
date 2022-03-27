package main.java.weekcompetition.week286;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/3/27 10:58
 */
public class LeetCode5253 {

    public static void main(String[] args) {
        int[] nums = {392015495, 5, 4, 1, 425320571, 565971690, 3, 7, 6, 3, 506222280, 468075092, 5};
        long[] res = kthPalindrome(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        if (intLength == 1) {
            int[] r = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            long[] res = new long[queries.length];
            for (int i = 0; i < queries.length; i++) {
                if (queries[i] > 9) {
                    res[i] = -1;
                } else {
                    res[i] = r[queries[i] - 1];
                }
            }
            return res;
        }
        //记录要查找长度为len中需要第max回文数
        int max = 0;
        for (int q : queries) {
            max = Math.max(max, q);
        }
        long[] res = new long[queries.length];

        List<Integer> h = new ArrayList<>();
        h.add(0);
        List<Integer> tmp = null;
        if (intLength % 2 == 0) {
            System.out.println("进入此处");
            int len = intLength / 2;
            //偶数长度
            //记录当前一起有几个回文数
            int start = 1;
            for (int i = 0; i < len - 1; i++) {
                start = start * 10;
            }
            int end = 9;
            for (int i = 0; i < len - 1; i++) {
                end = end + end * 10;
            }
            tmp = getTemp(len, max);
            for (int i = 0; i < tmp.size(); i++) {
                System.out.print(tmp.get(i) + " ");
            }
            for (int num : tmp) {
                if (num == -1) {
                    h.add(-1);
                    continue;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(num));
                int b = Integer.parseInt(sb.toString() + sb.reverse().toString());
                h.add(b);
            }
        } else {
            //奇数长度
            int len = intLength / 2 + 1;
            tmp = getTemp(len, max);
            for (int num : tmp) {
                if (num == -1) {
                    h.add(-1);
                    continue;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(num));
                int b = Integer.parseInt(sb.toString() + sb.reverse().toString().substring(1));
                h.add(b);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = h.get(queries[i]);
        }
        return res;
    }

    private static List<Integer> getTemp(int len, int maxNum) {
        System.out.println("len:" + len);
        List<Integer> res = new ArrayList<>();
        int start = 1;
        for (int i = 0; i < len - 1; i++) {
            start = start * 10;
        }
        int end = 9;
        for (int i = 0; i < len - 1; i++) {
            end = end + end * 10;
        }
        for (int i = 0; i < maxNum; i++) {
            if (start > end) {
                res.add(-1);
                continue;
            }
            res.add(start++);

        }
        return res;
    }

}
