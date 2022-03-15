package main.java.union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/28 22:15
 */
public class LeetCode1584 {

    static class UF {

        //记录每个节点的根节点
        int[] parent;
        //记录连通分量数量
        int count;

        public UF(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        //返回x节点的根节点
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        //判断p和q节点是否连通
        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        //将p和q节点连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {-1000000, -1000000},
                {1000000, 1000000}
        };
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                list.add(new int[]{i, j, dist});
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        UF uf = new UF(n);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] curr = list.get(i);
            int u = curr[0];
            int v = curr[1];
            int dist = curr[2];
            if (uf.isConnected(u, v)) {
                continue;
            }
            uf.union(u, v);
            sum += dist;
        }
        return sum;
    }
}
