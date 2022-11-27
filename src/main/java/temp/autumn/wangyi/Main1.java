package temp.autumn.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(canOpen(str));
    }

    private static boolean canOpen(String jsonStr) {
        if (jsonStr.length() <= 2) {
            return true;
        }
        List<List<Integer>> nums = parseJsonStrToList(jsonStr);
        boolean[] box = new boolean[nums.size()];
        box[0] = true;
        dfs(nums, 0, box);

        for (boolean b : box) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> nums, int curr, boolean[] box) {
        if (nums.get(curr).size() == 0) {
            return;
        }
        if (isAllOpen(nums.get(curr), box)) {
            return;
        }
        List<Integer> currNums = nums.get(curr);
        for (Integer num : currNums) {
            if (!box[num]) {
                box[num] = true;
                dfs(nums, num, box);
            }
        }
    }

    private static boolean isAllOpen(List<Integer> nums, boolean[] box) {
        int count = 0;
        for (Integer num : nums) {
            if (box[num]) {
                count++;
            }
        }
        return count == nums.size();
    }

    private static List<List<Integer>> parseJsonStrToList(String jsonStr) {
        List<List<Integer>> res = new ArrayList<>();
        String[] strs = jsonStr.substring(1, jsonStr.length() - 1).split("\\]");

        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                String[] nums = strs[i].substring(1).split(",");
                List<Integer> temp = new ArrayList<>();
                for (String num : nums) {
                    if (num.length() != 0) {
                        temp.add(Integer.parseInt(num));
                    }
                }
                res.add(temp);
                continue;
            }

            String[] nums = strs[i].substring(2).split(",");
            List<Integer> temp = new ArrayList<>();
            for (String num : nums) {
                if (num.length() != 0) {
                    temp.add(Integer.parseInt(num));
                }
            }
            res.add(temp);
        }

        return res;
    }
}
