package main.java.weekcompetition.week267;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2021/11/14 14:15
 */
public class LeetCode5929 {

    public static class UnionSet {
        int[] parents;
        int[] size;

        public UnionSet(int n, int[][] restrict) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 查找数的代表点，使用路径压缩，将集合扁平化处理
         *
         * @param x
         * @return
         */
        public int findFather(int x) {
            Stack<Integer> path = new Stack<>();
            while (parents[x] != x) {
                path.push(x);
                x = parents[x];
            }
            while (!path.isEmpty()) {
                parents[path.pop()] = x;
            }
            return x;
        }

        public boolean sameSet(int a, int b) {
            return findFather(a) == findFather(b);
        }

        public boolean union(int a, int b, int[][] restrictions) {
            int aHead = findFather(a);
            int bHead = findFather(b);
            for (int[] num : restrictions) {
                int head1 = findFather(num[0]);
                int head2 = findFather(num[1]);
                if ((aHead == head1 && bHead == head2) || (aHead == head2 && bHead == head1)) {
                    return false;
                }
            }
            int aSize = size[aHead];
            int bSize = size[bHead];
            int big = aSize >= bSize ? aHead : bHead;
            int small = big == aHead ? bHead : aHead;
            parents[small] = big;
            size[big] = aSize + bSize;
            size[small] = 0;
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] restrictions = {{0, 1}};
        int[][] requests = {{1, 2}, {0, 2}};
        boolean[] res = friendRequests(n, restrictions, requests);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionSet unionSet = new UnionSet(n, restrictions);
        int len = requests.length;
        boolean[] res = new boolean[len];
        for (int i = 0; i < len; i++) {
            res[i] = unionSet.union(requests[i][0], requests[i][1], restrictions);
        }
        return res;
    }
}
