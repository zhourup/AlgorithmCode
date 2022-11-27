package temp.autumn.xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] res = new int[t];

        initial();

        for (int i = 0; i < t; i++) {
            long num = in.nextLong();
            res[i] = getValue(num);
        }

        for (int n : res) {
            System.out.println(n);
        }
    }

    private static int getValue(long num) {
        if (num < 233) {
            return -1;
        }
        if (map.containsKey(num)) {
            return 1;
        }
        String s = String.valueOf(num);
        long key = getKey(s.length());
        if (num < key) {
            key = getKey(s.length() - 1);
            if (num % key == 0) {
                return (int) (num / key);
            } else {
                return -1;
            }
        } else {
            if (num % key == 0) {
                return (int) (num / key);
            } else {
                return -1;
            }
        }
    }

    private static long getKey(int len) {
        for (long key : map.keySet()) {
            if (map.get(key) == len) {
                return key;
            }
        }
        return 0;
    }

    private static void initial() {
        map.put(233L, 3);
        map.put(2330L, 4);
        map.put(23300L, 5);
        map.put(233000L, 6);
        map.put(2330000L, 7);
        map.put(23300000L, 8);
        map.put(233000000L, 9);
        map.put(2330000000L, 10);
        map.put(23300000000L, 11);
        map.put(233000000000L, 12);
        map.put(2330000000000L, 13);
        map.put(23300000000000L, 14);
    }
}
