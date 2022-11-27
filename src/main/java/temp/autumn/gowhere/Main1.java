package temp.autumn.gowhere;

public class Main1 {

    public static void main(String[] args) {
        int energy = 10;
        int[][] actions = {
                {1, 1},
                {2, 3},
                {3, 5},
                {5, 10},
                {7, 9},
                {8, 10}
        };
        System.out.println(maxScore(energy, actions));
    }

    public static int maxScore(int energy, int[][] actions) {
        if (energy == 0 || actions.length == 0) {
            return 0;
        }
        int W = energy;
        int N = actions.length;
        int[] wt = new int[actions.length];
        int[] val = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            wt[i] = actions[i][0];
            val[i] = actions[i][1];
        }
        return help(W, N, wt, val);
    }

    private static int help(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i - 1]] + val[i - 1],
                            dp[i - 1][w]
                    );
                }
            }
        }
        return dp[N][W];
    }
}
