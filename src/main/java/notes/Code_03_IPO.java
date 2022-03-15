package main.java.notes;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 贪心
 * 输入参数：成本数组const，利润数组profits，正数k，正数w
 * const[i]表示i号项目的花费，profits[i]表示i号项目扣除花费后的利润,k表示不能并行，只能串行的最多做k个项目，w是初始资金
 * 注意：每次只能做一个项目，每做完一个项目，马上获得的收益，可以去做下一个项目
 * 输出：最后获得的最大资金(包括初始资金)
 */
public class Code_03_IPO {

    public static class Node {
        public int p; // 利润
        public int c; // 成本

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxConstComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator()); // 花费小根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxConstComparator()); // 利润大根堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
