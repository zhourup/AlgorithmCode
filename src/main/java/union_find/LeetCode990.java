package main.java.union_find;

/**
 * @author zhourup
 * @date 2021/12/28 19:54
 */
public class LeetCode990 {

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
        String[] equations = new String[]{"a==b", "b==a"};
        System.out.println(equationsPossible(equations));
    }

    /**
     * 核心思想：将equations中的算式根据==和!=分成两部分，先处理==算式，使得他们通过相等关系构成连通分量；然后处理!=算式，检查不等关系是否
     * 破坏相等关系的连通性
     *
     * @param equations
     * @return
     */
    public static boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        //先让相等的字母形成连通分量
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        //检查不等关系是否打破相等关系的连通性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.isConnected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
