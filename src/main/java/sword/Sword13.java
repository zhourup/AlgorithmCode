package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/10 21:27
 */
public class Sword13 {

    public static void main(String[] args) {
        int m = 3, n = 1, k = 0;
        System.out.println(movingCount(m, n, k));
    }

    static boolean[][] visited;

    public static int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return move(m, n, 0, 0, k);
    }

    public static int move(int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        int a = i, b = j;
        int sum1 = 0, sum2 = 0;
        while (a > 0) {
            sum1 += a % 10;
            a = a / 10;
        }
        while (b > 0) {
            sum2 += b % 10;
            b = b / 10;
        }
        if (sum1 + sum2 > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + move(m, n, i + 1, j, k) + move(m, n, i - 1, j, k) +
                move(m, n, i, j + 1, k) + move(m, n, i, j - 1, k);
    }
}
