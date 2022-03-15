package main.java.others;

/**
 * @author zhourup
 * @date 2021/12/27 22:54
 */
public class LeetCode785 {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1},
                {0, 3},
                {3},
                {1, 2}
        };
        System.out.println(isBipartite(graph));
    }

    static boolean res = true;
    static boolean[] visited;
    static boolean[] color;

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return res;
    }

    private static void traverse(int[][] graph, int v) {
        //已经确定不是二分图，不必继续遍历了
        if (!res) {
            return;
        }
        visited[v] = true;
        for (int next : graph[v]) {
            if (!visited[next]) {
                //邻接节点没有被访问过
                color[next] = !color[v];
                traverse(graph, next);
            } else {
                //被访问过了
                if (color[next] == color[v]) {
                    res = false;
                    return;
                }
            }
        }
    }

}
