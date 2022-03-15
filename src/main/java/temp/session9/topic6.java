package main.java.temp.session9;

import java.util.Scanner;

/**
 * 递增三元组
 */
public class topic6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (a[i] < b[j] && b[j] < c[k]) count++;
                }
            }
        }
        System.out.println(count);
        in.close();
    }
}
