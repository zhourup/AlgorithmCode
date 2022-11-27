package temp.autumn.nio;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int n = in.nextInt();
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        String[] res = getRes(nums, n);
        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for (String r : res) {
            sb1.append(r).append(", ");
        }
        sb1.deleteCharAt(sb1.length() - 1);
        sb1.deleteCharAt(sb1.length() - 1);
        sb1.append("]");
        System.out.println(sb1.toString());
    }

    private static String[] getRes(int[] nums, int n) {
        String[] res = new String[nums.length];
        Arrays.fill(res,"True");
        return res;
    }
}
