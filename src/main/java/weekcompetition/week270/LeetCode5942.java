package main.java.weekcompetition.week270;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/5 10:31
 */
public class LeetCode5942 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 5};
        int[] evenNumbers = findEvenNumbers(nums);
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
    }

    /**
     * 法一
     *
     * @param digits
     * @return
     */
    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[digits.length];
        for (int i = 0; i < digits.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (digits[i] != 0) {
                if (visited[i]) {
                    continue;
                }
                sb.append(digits[i]);
                visited[i] = true;
                for (int j = 0; j < digits.length; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    sb.append(digits[j]);
                    visited[j] = true;
                    for (int k = 0; k < digits.length; k++) {
                        if (digits[k] % 2 == 1 || visited[k]) {
                            continue;
                        }
                        sb.append(digits[k]);
                        visited[k] = true;
                        set.add(Integer.valueOf(sb.toString()));
                        sb.deleteCharAt(sb.length() - 1);
                        visited[k] = false;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    visited[j] = false;
                }
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
        int[] res = new int[set.size()];
        int count = 0;
        for (Integer e : set) {
            res[count++] = e;
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * 法二
     *
     * @param digits
     * @return
     */
    public static int[] findEvenNumbers1(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int len = digits.length;
        for (int i = 0; i < len; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < len; k++) {
                    if (k == i || k == j || digits[k] % 2 != 0) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    set.add(num);
                }
            }
        }
        int size = set.size();
        int[] res = new int[size];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }
        Arrays.sort(res);
        return res;
    }
}
