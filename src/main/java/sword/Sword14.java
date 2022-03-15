package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/10 21:43
 */
public class Sword14 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(cuttingRope(n));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        return (int) (Math.pow(3, a) * 2);
    }
}
