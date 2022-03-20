package main.java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/3/20 13:32
 */
public class LeetCode47 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(path, nums, visited, res);
        return res;
    }


    public void backtrack(ArrayList<Integer> path, int[] num, boolean[] visited,
                          List<List<Integer>> res) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            //剪枝+避免重复
            //固定相同元素在排列中的相对位置
            if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(num[i]);
            backtrack(path, num, visited, res);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
