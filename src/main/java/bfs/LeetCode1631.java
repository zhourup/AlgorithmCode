package main.java.bfs;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/7 1:46
 */
public class LeetCode1631 {

    static class State {
        int x, y;
        //从(0,0)到当前坐标的最小体力消耗值
        int dist;

        public State(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(minimumEffortPath(nums));
    }

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] efforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });
        pq.offer(new State(0, 0, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int currX = curState.x;
            int currY = curState.y;
            int currEffort = curState.dist;
            // 判断是否到达右下角
            if (currX == m - 1 && currY == n - 1) {
                return currEffort;
            }
            if (currEffort > efforts[currX][currY]) {
                continue;
            }
            for (int[] neighbor : adj(heights, currX, currY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNext = Math.max(efforts[currX][currY], Math.abs(heights[currX][currY] - heights[nextX][nextY]));
                if (effortToNext < efforts[nextX][nextY]) {
                    pq.offer(new State(nextX, nextY, effortToNext));
                    efforts[nextX][nextY] = effortToNext;
                }
            }

        }
        return -1;
    }

    /**
     * 返回(x，y)的相邻格子坐标
     *
     * @param heights
     * @param x
     * @param y
     * @return
     */
    private static List<int[]> adj(int[][] heights, int x, int y) {
        int m = heights.length, n = heights[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }
}
