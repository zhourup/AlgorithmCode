package main.java.weekcompetition.week273;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/12/26 10:50
 */
public class LeetCode5965 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 10, 10};
        long[] res = getDistances1(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[j] == arr[i]) {
                    sum = sum + Math.abs(i - j);
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public static long[] getDistances1(int[] arr) {
        long[] res = new long[arr.length];
        //使用map存储相同元素的索引
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            } else {
                map.get(arr[i]).add(i);
            }
        }

        for (int num : map.keySet()) {
            List<Integer> list = map.get(num);

            if (list.size() == 1) {
                res[list.get(0)] = 0;
            } else {
                int M = list.size();
                long[] headToEnd = new long[M - 1];
                long[] endToHead = new long[M - 1];
                for (int j = 0; j < M - 1; j++) {
                    headToEnd[j] = list.get(j + 1) - list.get(0);
                    endToHead[j] = list.get(M - 1) - list.get(j);
                }

                for (int i = 0; i < headToEnd.length; i++) {
                    System.out.print(headToEnd[i] + " ");
                }
                System.out.println();
                for (int i = 0; i < endToHead.length; i++) {
                    System.out.print(endToHead[i] + " ");
                }
                System.out.println();

                //对headToEnd和endToHead求前缀和
                long[] headToEndSum = new long[M - 1];
                headToEndSum[0] = headToEnd[0];
                long[] endToHeadSum = new long[M - 1];
                endToHeadSum[M - 2] = endToHead[M - 2];
                for (int j = 1; j < M - 1; j++) {
                    headToEndSum[j] = headToEndSum[j - 1] + headToEnd[j];
                    endToHeadSum[M - 2 - j] = endToHeadSum[M - 1 - j] + endToHead[M - 2 - j];
                }

                for (int i = 0; i < headToEndSum.length; i++) {
                    System.out.print(headToEndSum[i] + " ");
                }
                System.out.println();
                for (int i = 0; i < endToHeadSum.length; i++) {
                    System.out.print(endToHeadSum[i] + " ");
                }
                System.out.println();
            }
        }

        return res;
    }
}
