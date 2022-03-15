package main.java.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/28 15:01
 */
public class LeetCode886 {

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = new int[][]{
                {1, 2},
                {1, 3},
                {2, 4}
        };
        System.out.println(possibleBipartition(n, dislikes));

    }

    static boolean ok = true;
    static boolean[] visited;
    static boolean[] color;

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = buildGraph(n, dislikes);
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    private static void traverse(List<List<Integer>> graph, int v) {
        //已经判定为非二分图，则没必要继续遍历了
        if (!ok) {
            return;
        }
        visited[v] = true;
        for (int next : graph.get(v)) {
            if (!visited[next]) {
                //相邻节点还没遍历过
                color[next] = !color[v];
                traverse(graph, next);
            } else {
                //相邻节点已经被遍历过了
                if (color[next] == color[v]) {
                    ok = false;
                    return;
                }
            }
        }
    }

    /**
     * 创建图
     *
     * @param n
     * @param dislikes
     * @return
     */
    private static List<List<Integer>> buildGraph(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        return graph;
    }
}
