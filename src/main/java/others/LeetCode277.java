package main.java.others;

import java.util.LinkedList;

/**
 * @author zhourup
 * @date 2021/12/29 11:10
 */
public class LeetCode277 {

    public static void main(String[] args) {
        System.out.println(findCelebrity(4));
    }

    /**
     * 找出名人：谁都认识他，但是他不认识任何人，即某个点入度为n-1，出度为1
     *
     * @param n
     * @return
     */
    private static int findCelebrity(int n) {
        int index = 0;
        //统计每个人的
        for (int i = 0; i < n; i++) {
            int in = 0;
            //统计第i个人的入度
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (!knows(j, i)) {
                    break;
                }
                in++;
            }
            int out = 0;
            //统计第i个人的出度
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(i, j)) {
                    out++;
                }
                if (out > 0) {
                    break;
                }
            }
            if (in == n - 1 && out == 0) {
                index = i;
            }
        }
        return index;
    }

    private static int findCelebrity1(int n) {
        //cand为候选人，判断其是否符合名人的条件
        for (int cand = 0; cand < n; cand++) {
            int other;
            for (other = 0; other < n; other++) {
                if (other == cand) {
                    continue;
                }
                //保证其他人都认识cand,且cand不认识任何其他人
                if (knows(cand, other) || !knows(other, cand)) {
                    break;
                }
            }
            if (other == n) {
                return cand;
            }
        }
        return -1;
    }

    private static int findCelebrity2(int n) {
        if (n == 1) {
            return 0;
        }
        //将所有候选人装入队列
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.addLast(i);
        }
        //一直排除，直到只剩下一个候选人
        while (q.size() >= 2) {
            int cand = q.removeFirst();
            int other = q.removeFirst();
            if (knows(cand, other) || !knows(other, cand)) {
                //cand不可能是名人，让other归队
                q.addFirst(other);
            } else {
                //other不可能是名人，让cand归队
                q.addFirst(cand);
            }
        }

        //现在排除得只剩下一个候选人，判断他是否真的是名人
        int cand = q.removeFirst();
        for (int other = 0; other < n; other++) {
            if (other == cand) {
                continue;
            }
            //保证其他人都认识cand，且cand不认识其他人
            if (knows(cand, other) || !knows(other, cand)) {
                return -1;
            }
        }
        return cand;
    }

    private static int findCelebrity3(int n) {
        //先假设cand是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (knows(cand, other) || !knows(other, cand)) {
                //cand不可能是名人
                cand = other;
            } else {
                //other不可能是名人
            }
        }

        for (int other = 0; other < n; other++) {
            if (cand == other) {
                continue;
            }
            if (knows(cand, other) || !knows(other, cand)) {
                return -1;
            }
        }
        return cand;
    }

    private static boolean knows(int i, int j) {
        int[][] graph = new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 1, 1}
        };
        return graph[i][j] == 1;
    }
}
