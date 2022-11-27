package temp.autumn.wangyimain;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] quanzhi = new int[n + 1];
        for (int i = 0; i < n; i++) {
            quanzhi[i + 1] = in.nextInt();
        }
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int[] num = new int[2];
            num[0] = in.nextInt();
            num[1] = in.nextInt();
            temp.add(num);
        }
        List<List<Integer>> graph = buildGraph(temp, n);
        System.out.println(getRes(n, graph, quanzhi));
    }

    private static int getRes(int n, List<List<Integer>> graph, int[] quanzhi) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int q = oneQ(i, graph, quanzhi, visited);
            int inz = getIngZi(q);
            inz = inz % 1000000007;
            res += inz;
        }
        return res % 1000000007;
    }

    //求index节点的权值x
    private static int oneQ(int index, List<List<Integer>> graph, int[] quanzhi, boolean[] visited) {
        if (visited[index]) {
            return 1;
        }
        int res = quanzhi[index];
        visited[index] = true;
        List<Integer> curr = graph.get(index);
        for (int next : curr) {
            res = res * oneQ(next, graph, quanzhi, visited);
        }
        return res;
    }

    static Map<Integer, Integer> map = new HashMap<>();

    private static int getIngZi(int q) {
        if (map.containsKey(q)) {
            return map.get(q);
        }
        int count = 0;
        for (int i = 1; i < Math.sqrt(q); i++) {
            if (q % i == 0) {
                count += 2;
            }
        }
        map.put(q, count);
        return count;
    }

    private static List<List<Integer>> buildGraph(List<int[]> temp, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> te = new ArrayList<>();
            graph.add(te);
        }

        for (int[] num : temp) {
            graph.get(num[0]).add(num[1]);
        }
        return graph;
    }
}
