package main.java.bfs;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 标准的Dijkstra算法会把从起点start到所有其他点的最短路径都算出来
 *
 * @author zhourup
 * @date 2021/12/6 14:21
 */
public class DijkstraCode {

    class State {
        //图节点的id
        int id;
        //从start节点到当前节点的距离
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public static void main(String[] args) {

    }

    //返回节点from到节点to之间边的权重
    int weight(int from, int to) {
        return 0;
    }

    //返回节点s的相邻节点
    List<Integer> adj(int s) {
        return null;
    }

    //输入一幅图和一个起点start，计算start到其他节点的最短距离
    int[] dijkstra(int start, List<Integer>[] graph) {
        //图中节点的个数
        int V = graph.length;
        // distTo[i]的值是节点start到节点i的最短路径权重
        int[] distTo = new int[V];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int currNodeId = curr.id;
            int currDistFromStart = curr.distFromStart;
            if (currDistFromStart > distTo[currNodeId]) {
                continue;
            }
            //将curr的相邻节点装入队列
            for (int nextNodeID : adj(currNodeId)) {
                int distToNextNode = distTo[currNodeId] + weight(currNodeId, nextNodeID);
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
