package main.java.hot100;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2021/11/13 10:58
 */
public class Hot406 {

    public static void main(String[] args) {
        int[][] nums = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}};
        int[][] res = reconstructQueue(nums);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] >= i) {
                res[i] = people[i];
            } else {
                int target = people[i][1];
                for (int j = i; j > target; j--) {
                    res[j] = res[j - 1];
                }
                res[target] = people[i];
            }
        }
        return res;
    }
}