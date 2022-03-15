package main.java.weekcompetition.week67;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/11 23:21
 */
public class LeetCode5936 {

    static class Node {
        //当前炸弹的坐标
        int x;
        int y;
        //当前炸弹爆炸能影响的炸弹
        List<Node> adj;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            adj = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {2, 3, 1},
                {3, 4, 2},
                {4, 5, 3},
                {5, 6, 4},
        };
        int[][] nums1 = new int[][]{
                {37207, 2653, 5261},
                {40784, 59523, 20635},
                {16390, 1426, 39102},
                {42236, 12, 96855},
                {72839, 62027, 61667},
                {60691, 58191, 48447},
                {42932, 46579, 41248},
                {35868, 43119, 6870},
                {41693, 98905, 17374},
                {43441, 1266, 41621}
        };
        System.out.println(maximumDetonation(nums1));
    }

    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j && isConnect(bombs, i, j)) {
                    list.add(j);
                }
            }
            edges.put(i, list);
        }
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        //从每个开始依次BFS，求最大连同数量
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            queue.offer(i);
            visited[i] = true;
            int count = 1;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                List<Integer> edge = edges.get(u);
                for (Integer v : edge) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                        count++;
                    }
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }

    /**
     * 判断炸弹u能否引爆炸弹v
     *
     * @param bombs
     * @param u
     * @param v
     * @return
     */
    private static boolean isConnect(int[][] bombs, int u, int v) {
        long x = bombs[u][0] - bombs[v][0];
        long y = bombs[u][1] - bombs[v][1];
        long scope = (long) bombs[u][2] * bombs[u][2];
        return scope >= x * x + y * y;
    }
}
