package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/13 16:54
 */
public class Sword17 {

    public static void main(String[] args) {
        int n = 3;
        int[] res = printNumbers(n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
