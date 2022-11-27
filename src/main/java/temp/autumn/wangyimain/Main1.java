package temp.autumn.wangyimain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }
        System.out.println(getRes(nums, k));

    }

    static Map<Long, Long> map = new HashMap<>();

    private static int getRes(long[] nums, int k) {
        long[] temp = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = getMinNum(nums[i], k);
        }
        Map<Long, Long> count = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            count.put(temp[i], count.getOrDefault(temp[i], 0L) + 1);
        }
        if (count.size() == temp.length) {
            return 0;
        }
        long max = 0;
        for (long c : count.values()) {
            max = Math.max(max, c);
        }
        return (int) max;
    }

    private static long getMinNum(long num, int k) {
        if (map.containsKey(num)) {
            return map.get(num);
        }

        map.put(num, num % k);
        return num % k;
    }
}
