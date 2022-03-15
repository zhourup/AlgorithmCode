package main.java.dfs;

public class LeetCode200 {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        if (r > 0 && grid[r - 1][c] == '1') dfs(grid, r - 1, c);
        if (c < grid[0].length - 1 && grid[r][c + 1] == '1') dfs(grid, r, c + 1);
        if (r < grid.length - 1 && grid[r + 1][c] == '1') dfs(grid, r + 1, c);
        if (c > 0 && grid[r][c - 1] == '1') dfs(grid, r, c - 1);
    }
}
