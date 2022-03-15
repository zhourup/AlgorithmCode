package main.java.temp.session9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 复数幂
 */
public class topic3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Long> list = new ArrayList<>(2);
        long a = 2;
        long b = 3;
        list.add(a);
        list.add(b);
        List<Long> res = multiply(list);
        if (n == 1) {
            System.out.println("2+3i");
        } else {
            for (int i = 0; i < n - 1; i++) {
                res = multiply(list);
                list = res;
            }
            if (res.get(1) > 0) {
                System.out.println(res.get(0) + "+" + res.get(1) + "i");
            } else {
                System.out.println(res.get(0) + "" + res.get(1) + "i");
            }
        }
        scan.close();
    }

    private static List<Long> multiply(List<Long> list) {
        List<Long> res = new ArrayList<>(2);
        long d1 = list.get(0) * 2;
        long d2 = list.get(0) * 3;
        long d3 = list.get(1) * 2;
        long d4 = -list.get(1) * 3;
        res.add(d1 + d4);
        res.add(d2 + d3);
        return res;
    }
}
