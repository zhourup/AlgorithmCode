package main.java.weekcompetition.week287;

import java.util.*;

/**
 * @author zhourup
 * @date 2022/4/3 10:43
 */
public class LeetCode5235 {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {10, 4},
                {10, 9},
        };
        List<List<Integer>> res = findWinners(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> lossOne = new ArrayList<>();
        res.add(noLoss);
        res.add(lossOne);

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> lossMap = new HashMap<>();

        for (int[] ma : matches) {
            int win = ma[0];
            int loss = ma[1];
            set.add(win);
            lossMap.put(loss, lossMap.getOrDefault(loss, 0) + 1);

        }
        for (Integer key : set) {
            if (!lossMap.containsKey(key)) {
                noLoss.add(key);
            }
        }
        for (Integer key : lossMap.keySet()) {
            if (lossMap.get(key) == 1) {
                lossOne.add(key);
            }
        }
        Collections.sort(noLoss);
        Collections.sort(lossOne);
        return res;
    }
}
