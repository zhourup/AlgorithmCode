package main.java.greedy;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2022/3/30 15:17
 */
public class LeetCode1024 {

    public static void main(String[] args) {
        int[][] clips = {
                {0, 2},
                {4, 6},
                {8, 10},
                {1, 9},
                {1, 5},
                {5, 9},
        };
        int time = 10;
        System.out.println(videoStitching(clips, time));
    }

    public static int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int res = 0;
        int curEnd = 0, nextEnd = 0;
        int i = 0, n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                return res;
            }
        }
        //无法继续拼接区间[0,T]
        return -1;
    }
}
