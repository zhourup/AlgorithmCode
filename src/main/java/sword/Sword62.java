package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 19:19
 */
public class Sword62 {

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(lastRemaining(n, m));
    }

    public static int lastRemaining(int n, int m) {
        return f(n, m);
    }

    private static int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
