package temp.autumn.jingdong;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getMinOperate(nums));
    }

    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, List<int[]>> list = new HashMap<>();

    private static int getMinOperate(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                count += map.get(num);
            } else {
                int res = help(num);
                count += res;
                map.put(num, res);
            }
        }
        return count;
    }

    private static int help(int num) {
        if (num <= 1) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        int res1 = 1;
        if (map.containsKey(num - 1)) {
            res1 += map.get(num - 1);
        } else {
            int aa = help(num - 1);
            res1 += aa;
            map.put(num - 1, aa);
        }

        List<int[]> temp = getChengList(num);
        int res2 = getChaiTime(temp);
        return Math.min(res1, res2);
    }

    private static int getChaiTime(List<int[]> nums) {
        if (nums.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int[] num : nums) {
            min = Math.min(min, help(num[0]) + help(num[1]) + 1);
        }
        return min;
    }

    private static List<int[]> getChengList(int num) {
        if (list.containsKey(num)) {
            return list.get(num);
        }

        List<int[]> res = new ArrayList<>();
        if (num == 1) {
            int[] nums = {1, 1};
            res.add(nums);
            list.put(1, res);
            return res;
        }

        for (int i = 2; i <= num / 2; i++) {
            int chu = num / i;
            if (num == chu * i) {
                int[] a = {i, num / i};
                res.add(a);
            }
        }
        list.put(num, res);
        return res;
    }
}
