package main.java.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhourup
 * @date 2021/12/3 20:32
 */
public class LeetCode752 {

    public static void main(String[] args) {
        String[] deads = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock1(deads, target));
    }

    /**
     * 法一、BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        // 从起点开始启动广度优先搜索
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String curr = q.poll();
                if (deads.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return step;
                }
                //将一个节点的未遍历相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = upOne(curr, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = downOne(curr, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 法二、法一的优化，双向BFS
     * 双向BFS可以提高算法的效率，前提是必须知道终点在哪里
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock1(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 用集合不用队列，可以判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在扩散过程中不能修改，用temp存储扩散结果
            Set<String> temp = new HashSet<>();

            //将q1中的所有节点向周围扩散
            for (String cur : q1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                //将一个节点未遍历的相邻节点加入集合
                for (int j = 0; j < 4; j++) {
                    String up = upOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = downOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    //将s[j]向+方向拨动一次
    private static String upOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    //将s[j]向-方向拨动一次
    private static String downOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
