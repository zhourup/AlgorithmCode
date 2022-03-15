package main.java.others;

/**
 * @author zhourup
 * @date 2021/12/20 11:05
 */
public class LeetCode997 {

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = new int[][]{
                {1, 3},
                {2, 3},
                {3, 1},
        };
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        //被信任数量
        int[] count = new int[n + 1];
        //信任数量
        int[] count1 = new int[n + 1];
        for (int[] tr : trust) {
            count[tr[1]]++;
            count1[tr[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1 && count1[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
