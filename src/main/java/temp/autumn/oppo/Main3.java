package temp.autumn.oppo;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(tourismRoutePlanning1(4));
    }

    public static long tourismRoutePlanning(int scenicspot) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= scenicspot; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static long tourismRoutePlanning1(int scenicspot) {
        int[] dp = new int[scenicspot];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < scenicspot; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[scenicspot - 1];
    }
}
