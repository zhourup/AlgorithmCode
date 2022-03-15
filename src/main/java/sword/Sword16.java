package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/13 15:41
 */
public class Sword16 {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        System.out.println(myPow1(x, n));
    }

    /**
     * 法一、超出时间限制
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double res = 1;
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return flag ? 1 / res : res;
    }

    /**
     * 法二、快速幂
     * 向下取整n//2等价于右移一位n>>1
     * 取余数n%2等价于判断二进制最右一位n&1
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;

        }
        return res;
    }
}
