package main.java.greedy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1217 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minCostToMoveChips(nums));
    }

    /**
     * 法一：自己写的
     *
     * @param position
     * @return
     */
    public static int minCostToMoveChips(int[] position) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < position.length; i++) {
            if (!set.contains(position[i])) {
                int tmp = moveCost(position, position[i]);
                min = Math.min(min, tmp);
                set.add(position[i]);
            }
        }
        return min;
    }

    public static int moveCost(int[] position, int index) {
        int count = 0;
        for (int i = 0; i < position.length; i++) {
            if (index < position[i]) {
                count += startToEndCos(index, position[i]);
            } else if (index > position[i]) {
                count += startToEndCos(position[i], index);
            }
        }
        return count;
    }

    public static int startToEndCos(int start, int end) {
        int tmp = end - start;
        if (tmp % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 法二：
     *
     * @param position
     * @return
     */
    public static int minCostToMoveChips1(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
