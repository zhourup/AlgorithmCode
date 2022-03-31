package main.java.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/3/31 17:14
 */
public class Sword57II {

    public static void main(String[] args) {
        int target = 9;
        int[][] res = findContinuousSequence(target);
        for (int[] num : res) {
            for (int n : num) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (sum == target) {
                int[] tmp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    tmp[i - left] = i;
                }
                res.add(tmp);
            }
            if (sum >= target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
    }
}
