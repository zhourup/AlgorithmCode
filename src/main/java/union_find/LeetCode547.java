package main.java.union_find;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode547 {

    public static void main(String[] args) {
        int[][] data = {{1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        System.out.println(findCircleNum2(data));
    }

    /**
     * 法一：深度优先搜索,自己写的
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum1(int[][] isConnected) {
        int len = isConnected.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    count++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] nums, int row, int col) {
        nums[row][col] = 0;
        // 将行对应的1给置0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][col] == 1) {
                dfs(nums, i, col);
            }
        }
        // 将列对应的1给置0
        for (int i = 0; i < nums.length; i++) {
            if (nums[row][i] == 1) {
                dfs(nums, row, i);
            }
        }
    }

    public static int findCircleNum2(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, len, i);
            }
        }
        return count;
    }

    private static void dfs(int[][] nums, boolean[] visited, int len, int i) {
        for (int j = 0; j < len; j++) {
            if (nums[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(nums, visited, len, j);
            }
        }
    }

    /**
     * BFS
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum3(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < len; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                count++;
            }
        }
        return 0;
    }

    /**
     * 并查集，计算连通分量数的另外一个方法是使用并查集
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum4(int[][] isConnected) {
        int len = isConnected.length;
        int[] parents = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (parents[i] == i) {
                count++;
            }
        }
        return count;
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);

    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
