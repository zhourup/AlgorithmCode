package main.java.hot100;

public class Hot7 {

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            if (ret < Integer.MIN_VALUE / 10 || ret > Integer.MAX_VALUE) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            ret = ret * 10 + digit;
        }
        return ret;
    }
}
