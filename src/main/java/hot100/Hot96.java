package main.java.hot100;

public class Hot96 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] = G[i] + G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /**
     * 法二、数学知识：卡塔兰数
     *
     * @param n
     * @return
     */
    public static int numTrees1(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }

    /**
     * 法三
     *
     * @param n
     * @return
     */
    public static int numTrees2(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    /**
     * 存储已经计算过的结果，解决重叠子问题
     */

    static int[][] memo;

    /**
     * 计算区间[left,right]组成的BST的个数
     *
     * @param left
     * @param right
     * @return
     */
    private static int count(int left, int right) {
        if (left > right) {
            return 1;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int l = count(left, i - 1);
            int r = count(i + 1, right);
            res += l * r;
        }
        memo[left][right] = res;
        return res;
    }
}
