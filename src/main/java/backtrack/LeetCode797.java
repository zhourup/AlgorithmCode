package main.java.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/27 20:25
 */
public class LeetCode797 {


    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> result = allPathsSourceTarget(graph);
        for (List<Integer> list : result) {
            System.out.println("list:" + list);
        }

    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);

        return res;
    }

    private static void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);

        if (s == graph.length - 1) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int next : graph[s]) {
            traverse(graph, next, path);
        }
        path.removeLast();
    }
}
