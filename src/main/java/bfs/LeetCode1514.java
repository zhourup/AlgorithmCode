package main.java.bfs;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/7 18:40
 */
public class LeetCode1514 {

    static class State {
        int id;
        //从起点start到当前点的最大概率
        double prob;

        public State(int id, double prob) {
            this.id = id;
            this.prob = prob;
        }
    }

    static class Node {
        int id;
        double prob;

        public Node(int end, double prob) {
            this.id = end;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{{0, 1}};
        double[] succProb = new double[]{0.5};
        int start = 0, end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end));

    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] probs = new double[n];
        Arrays.fill(probs, Double.MIN_VALUE);
        probs[start] = 1;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            if (a.prob > b.prob) {
                return -1;
            } else {
                return 1;
            }
        });
        pq.offer(new State(start, 1));
        List<List<Node>> graph = generateGraph(n, edges, succProb);
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeId = curState.id;
            double curProb = curState.prob;
            if (curNodeId == end) {
                return curProb;
            }
            if (curProb < probs[curNodeId]) {
                continue;
            }
            for (Node nextNode : graph.get(curNodeId)) {
                int nextNodeId = nextNode.id;
                double nextProb = nextNode.prob;
                double toNextProb = probs[curNodeId] * nextProb;
                if (toNextProb > probs[nextNodeId]) {
                    probs[nextNodeId] = toNextProb;
                    pq.offer(new State(nextNodeId, toNextProb));
                }
            }
        }
        return 0;
    }

    private static List<List<Node>> generateGraph(int n, int[][] edges, double[] succProb) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Node> list = new ArrayList<>();
            graph.add(list);
        }
        int index = 0;
        for (int[] edge : edges) {
            int in = edge[0];
            int out = edge[1];
            double prob = succProb[index++];
            graph.get(in).add(new Node(out, prob));
            graph.get(out).add(new Node(in, prob));
        }
        return graph;
    }
}
