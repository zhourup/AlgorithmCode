package main.java.temp.session9;

import java.util.Scanner;

/**
 * 全球变暖
 * 注意：两种岛屿，一个#上下左右都有#的岛屿则不会淹没，其余的岛屿会被淹没
 */
public class topic9 {
    static int n = 0;
    static char[][] mp = new char[1005][1005];
    static boolean[][] vis = new boolean[1005][1005];
    static int[] ans = new int[100005];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            for (int j = 0; j < n; j++) {
                mp[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mp[i][j] == '#' && !vis[i][j]) {
                    dfs(i, j, count);
                    count++;
                }
            }
        }
        int ans1 = 0;
        for (int i = 0; i < count; i++) {
            if (ans[i] == 0) {
                ans1++;
            }
        }
        System.out.println(ans1);
        in.close();
    }

    private static void dfs(int x, int y, int cnt) {
        if (x < 0 || y < 0 || x >= n || y >= n) return;
        if (vis[x][y]) return;
        if (mp[x][y] == '.') return;
        vis[x][y] = true;
        if (mp[x - 1][y] == '#' && mp[x + 1][y] == '#' && mp[x][y - 1] == '#' && mp[x][y + 1] == '#') {
            ans[cnt]++;
        }
        dfs(x - 1, y, cnt);
        dfs(x + 1, y, cnt);
        dfs(x, y - 1, cnt);
        dfs(x, y + 1, cnt);
    }

}
