package main.java.dfs;

/**
 * @author zhourup
 * @date 2021/12/4 14:21
 */
public class LeetCode1905 {

    public static void main(String[] args) {
        int[][] nums1 = new int[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };
        int[][] nums2 = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        System.out.println(countSubIslands1(nums1, nums2));
    }

    /**
     * 法一、DFS，直接求符合题目要求的子岛屿数量
     *
     * @param grid1
     * @param grid2
     * @return
     */
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                    boolean isLand = isSubIsland(grid1, grid2, i, j);
                    if (isLand) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length, n = grid2[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return true;
        }
        if (grid2[i][j] == 1 && grid1[i][j] == 0) {
            return false;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        grid1[i][j] = 0;
        boolean up = isSubIsland(grid1, grid2, i - 1, j);
        boolean down = isSubIsland(grid1, grid2, i + 1, j);
        boolean left = isSubIsland(grid1, grid2, i, j - 1);
        boolean right = isSubIsland(grid1, grid2, i, j + 1);
        return up && down && left && right;
    }


    /**
     * 法二、DFS,先将不是子岛的排除掉，剩下的就是子岛
     *
     * @param grid1
     * @param grid2
     * @return
     */
    public static int countSubIslands1(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    //这个岛屿肯定不是子岛屿，排除掉
                    dfs(grid2, i, j);
                }
            }
        }

        //现在grid2中剩下的岛屿全是子岛屿，计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
