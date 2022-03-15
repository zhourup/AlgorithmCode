package main.java.temp.session11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * H:作物杂交
 */
public class topic8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, k, t;
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        t = in.nextInt();
        int[] times = new int[n + 1]; //n种作物的种植时间
        for (int i = 1; i <= n; i++) {
            times[i] = in.nextInt();
        }
        boolean[] flags = new boolean[n + 1];
        Arrays.fill(flags, false);
        for (int i = 1; i <= m; i++) {
            int tmp = in.nextInt();
            flags[tmp] = true;
        }
        int[][] ways = new int[k + 1][4]; //第四列用于记录当前该方法有没有合成
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 3; j++) {
                ways[i][j] = in.nextInt();
            }
            ways[i][3] = 0;
        }

        int minTime = 0;
        while (!flags[t]) {
            for (int i = 1; i <= k; i++) {
                if (flags[ways[i][0]] && flags[ways[i][1]] && (!flags[ways[i][2]])) {
                    ways[i][3] = 1;
                }
            }
            int rundTime = 0;
            for (int i = 1; i <= k; i++) {
                if (ways[i][3] == 1) {
                    ways[i][3] = 0;
                    flags[ways[i][2]] = true;
                    int temp = times[ways[i][0]] > times[ways[i][1]] ? times[ways[i][0]] : times[ways[i][1]];
                    rundTime = rundTime > temp ? rundTime : temp;
                }
            }
            System.out.println("该轮合成时间："+rundTime);
            minTime += rundTime;
        }
        System.out.println("time:" + minTime);
    }
}
