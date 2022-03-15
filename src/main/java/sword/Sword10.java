package main.java.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2022/3/10 17:11
 */
public class Sword10 {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(fib(n));
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = fib(n - 1) + fib(n - 2);
        res = res % 1000000007;
        map.put(n, res);
        return res;
    }
}
