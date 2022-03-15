package main.java.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhourup
 * @date 2021/12/4 15:13
 */
public class LeetCode694 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int[][] nums1 = new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println(numDistinctIslands(nums1));

    }

    public static int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录室友岛屿的序列化结果
        Set<String> isLands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //淹掉这个岛屿，同时存储这个岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 666);
                    isLands.add(sb.toString());
                    System.out.println("i:" + i + " j:" + j + "  " + sb.toString());
                }
            }
        }
        return isLands.size();
    }

    /**
     * 记录每次岛屿遍历的顺序
     *
     * @param grid
     * @param i
     * @param j
     * @param sb
     * @param dir
     */
    private static void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i - 1, j, sb, 1);
        dfs(grid, i + 1, j, sb, 2);
        dfs(grid, i, j - 1, sb, 3);
        dfs(grid, i, j + 1, sb, 4);
        sb.append(-dir).append(',');
    }
}
