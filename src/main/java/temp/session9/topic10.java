package main.java.temp.session9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 堆的计数
 */
public class topic10 {
    static long count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        generateGroup(n);
        System.out.println(count%1000000009);
    }

    /**
     * 法一，能解决部分，因为深度递归的层数过大，栈会溢出
     *
     * @param n
     */
    private static void generateGroup(int n) {
        boolean[] flags = new boolean[n + 1];
        List<Integer> temp = new ArrayList<>();
        dfs(n, temp, flags);
    }

    private static void dfs(int n, List<Integer> temp, boolean[] flags) {
        if (temp.size() == n&&isSmallRootPile(temp)) {
            count++;
//            打印符合小根堆的数字组合
            for (int i = 0; i < temp.size(); i++) {
                System.out.print(temp.get(i));
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if (flags[i]) continue;
            temp.add(i+1);
            flags[i] = true;
            dfs(n, temp, flags);
            temp.remove(temp.size() - 1);
            flags[i] = false;
        }
    }

    private static boolean isSmallRootPile(List<Integer> nums) {
        if (nums.size() <= 1) return true;
        for (int i = 0; i <= nums.size() / 2 - 1; i++) {
            if (nums.get(i) > nums.get(2 * i + 1)) return false;
            if ((2 * i + 2) < nums.size() && nums.get(i) > nums.get(2 * i + 2)) return false;
        }
        return true;
    }
}
