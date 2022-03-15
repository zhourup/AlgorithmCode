package main.java.topology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/27 22:23
 */
public class LeetCode210 {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = findOrder(numCourses, prerequisites);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    static boolean hasCycle = false;
    static boolean[] visited;
    static boolean[] onPath;
    /**
     * 记录后序遍历结果
     */
    static List<Integer> postOrder = new ArrayList<>();

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for (int[] num : prerequisites) {
            graph.get(num[1]).add(num[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i);
        }

        //不能完成
        if (hasCycle) {
            return new int[]{};
        }
        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }


    private static void dfs(List<List<Integer>> graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
            return;
        }
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (Integer next : graph.get(s)) {
            dfs(graph, next);
        }
        postOrder.add(s);
        onPath[s] = false;
    }
}
