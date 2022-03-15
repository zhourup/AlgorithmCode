package main.java.weekcompetition.week270;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/5 14:57
 */
public class LeetCode5932 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {5, 1},
                {4, 5},
                {11, 9},
                {9, 4}
        };
        int[][] res = validArrangement1(nums);
        for (int[] num : res) {
            System.out.println(num[0] + " " + num[1]);
        }

    }

    /**
     * 用于记录每个数字在int[0]的个数，int[1]的个数
     */
    static Map<Integer, int[]> countMap = new HashMap<>();
    /**
     * 用于记录某个数字和其他数字组成int[],map的key是int[0]，Queue中的元素int[1]的可能数字
     */
    static Map<Integer, Queue<Integer>> map = new HashMap<>();
    static List<Integer> path = new ArrayList<>();

    /**
     * 法二、构建欧拉回路
     *
     * @param pairs
     * @return
     */
    public static int[][] validArrangement1(int[][] pairs) {
        int len = pairs.length;
        int[][] res = new int[len][2];
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            countMap.putIfAbsent(start, new int[2]);
            countMap.putIfAbsent(end, new int[2]);
            countMap.get(start)[0]++;
            countMap.get(end)[1]++;
            if (!map.containsKey(start)) {
                map.put(start, new ArrayDeque<>());
            }
            map.get(start).offer(end);
        }
        int source = pairs[0][0];
        Set<Integer> set = countMap.keySet();
        for (int num : set) {
            int[] count = countMap.get(num);
            if (count[0] > count[1]) {
                //找到起点
                source = num;
                break;
            }
        }
        dfs(source);
        Collections.reverse(path);
        for (int i = 0; i < len; i++) {
            int start = path.get(i);
            int end = path.get(i + 1);
            res[i][0] = start;
            res[i][1] = end;

        }
        return res;
    }

    public static void dfs(int num) {
        while (map.containsKey(num) && map.get(num).size() > 0) {
            int tmp = map.get(num).poll();
            dfs(tmp);
        }
        //记录走过的数字
        path.add(num);
    }

    static int[][] res;

    /**
     * 法一、回溯 枚举全部可能，会超时
     *
     * @param pairs
     * @return
     */
    public static int[][] validArrangement(int[][] pairs) {
        List<int[]> path = new ArrayList<>();
        boolean[] visited = new boolean[pairs.length];
        backtrack(pairs, path, visited);
        return res;
    }

    private static void backtrack(int[][] pairs, List<int[]> path, boolean[] visited) {
        if (path.size() == pairs.length) {
            res = new int[pairs.length][2];
            int index = 0;
            for (int[] pair : path) {
                res[index++] = pair;
            }
            return;
        }
        int sz = path.size();
        int[] pre;
        if (sz == 0) {
            pre = new int[]{-1, -1};
        } else {
            pre = path.get(sz - 1);
        }
        for (int i = 0; i < pairs.length; i++) {
            int[] curr = pairs[i];
            if (visited[i] || (pre[1] != curr[0] && pre[1] != -1)) {
                continue;
            }
            //做选择
            path.add(curr);
            visited[i] = true;
            backtrack(pairs, path, visited);
            //撤销选择
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
