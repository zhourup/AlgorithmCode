package main.java.temp.session9;

import java.util.Scanner;

/**
 * 螺旋折线
 */
public class topic7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        long d = 0;
        if (y >= Math.abs(x)) {
            int n = y;
            d = (2 * n - 1) * (2 * n) + x - (-n);
        }
    }
}
