package main.java.bfs;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/6 16:06
 */
public class LeetCode743 {

    static class State {
        //当前节点id
        int id;
        //记录起点到当前节点的最短距离
        int dist;

        public State(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(nums, n, k));
    }

    static List<List<Integer>> graph;
    static Map<String, Integer> weight = new HashMap<>();

    /**
     * 法二
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime1(int[][] times, int n, int k) {
        //节点编号从1开始，需构造大小为n+1的领接表
        List<List<int[]>> graph = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            List<int[]> list = new ArrayList<>();
            graph.add(list);
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new int[]{to, weight});
        }
        int[] dists = dijkstra(graph, k);
        int max = 0;
        for (int i = 1; i < dists.length; i++) {
            if (dists[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dists[i]);
        }
        return max;
    }

    /**
     * 计算起点到其他节点的最短距离
     *
     * @param graph
     * @param start
     * @return
     */
    private static int[] dijkstra(List<List<int[]>> graph, int start) {
        int[] dists = new int[graph.size()];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });
        State state = new State(start, 0);
        pq.offer(state);
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeId = curState.id;
            int curNodeDist = curState.dist;
            if (curNodeDist > dists[curNodeId]) {
                continue;
            }

            //将curNode的相邻节点装入队列
            for (int[] neighbor : graph.get(curNodeId)) {
                int nextNodeId = neighbor[0];
                //将dists[curNodeId]和currNodeDist比较
                int distToNext = dists[curNodeId] + neighbor[1];
                if (dists[nextNodeId] > distToNext) {
                    dists[nextNodeId] = distToNext;
                    pq.offer(new State(nextNodeId, distToNext));
                }
            }

        }
        return dists;
    }

    /**
     * 法一、先构建图，然后从起点开始使用Dijkstra算法求k点到其他点的最短路径
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime(int[][] times, int n, int k) {
        //需要有两个方法，1、给定起点和终点，返回其边权值；2、给定节点，返回其相邻的节点
        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] = 0;
        int max = -1;
        initial(times, n, k);

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });
        pq.offer(new State(k, 0));
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            if (curr.dist < dists[curr.id]) {
                dists[curr.id] = curr.dist;
            }

            if (graph.get(curr.id).size() != 0) {
                for (Integer next : graph.get(curr.id)) {
                    String key = curr.id + "_" + next;
                    Integer newDist = weight.get(key) + curr.dist;
                    if (newDist < dists[next]) {
                        pq.offer(new State(next, newDist));
                    }
                }
            }
        }
        for (int i = 1; i < dists.length; i++) {
            if (dists[i] != Integer.MAX_VALUE) {
                max = Math.max(max, dists[i]);
            } else {
                return -1;
            }
        }
        return max;
    }

    private static void initial(int[][] times, int n, int k) {
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for (int[] time : times) {
            graph.get(time[0]).add(time[1]);
            weight.put(time[0] + "_" + time[1], time[2]);
        }
    }
}
