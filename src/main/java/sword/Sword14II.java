package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/12 19:03
 */
public class Sword14II {

    public static void main(String[] args) {
        int n = 120;
        System.out.println(cuttingRope(n));
//        int res = 1;
//        for (int i = 0; i < 40; i++) {
//            res = res * 3 % 1000000007;
//        }
//        System.out.println(res);
    }

    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int a = n / 3, b = n % 3;
        if (b == 0) {
            for (int i = 0; i < a; i++) {
                res = res * 3 % 1000000007;
            }
            return (int) res;
        }
        if (b == 1) {
            for (int i = 0; i < a - 1; i++) {
                res = res * 3 % 1000000007;
            }
            res = res * 4 % 1000000007;
            return (int) res;
        }
        for (int i = 0; i < a; i++) {
            res = res * 3 % 1000000007;
        }
        res = res * 2 % 1000000007;
        return (int) res;
    }
}
