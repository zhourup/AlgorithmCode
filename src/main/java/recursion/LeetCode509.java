package main.java.recursion;

public class LeetCode509 {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    /**
     * 法一：最菜的写法，递归
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * 法二：知道递推公式，可以使用动态规划求解
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
