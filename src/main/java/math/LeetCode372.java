package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/15 10:50
 */
public class LeetCode372 {

    public static void main(String[] args) {
        int a = 2;
        int[] b = {3};
        System.out.println(superPow(a, b));
    }


    static int base = 1337;

    public static int superPow(int a, int[] b) {
        return superPowPlus(a, b, b.length);
    }

    public static int superPowPlus(int a, int[] b, int len) {
        if (len == 0) {
            return 1;
        }
        int last = b[len - 1];
        len--;
        int part1 = mypow(a, last);
        int part2 = mypow(superPowPlus(a, b, len), 10);
        return part1 * part2 % base;
    }

    /**
     * 计算a的k次方
     *
     * @param a
     * @param k
     * @return
     */
    private static int mypow(int a, int k) {
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }

    /**
     * 快速求高次幂
     *
     * @param a
     * @param k
     * @return
     */
    private static int mypow1(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a %= base;
        if (k % 2 == 1) {
            return (a * mypow1(a, k - 1)) % base;
        } else {
            int sub = mypow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
