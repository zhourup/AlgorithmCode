package main.java.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhourup
 * @date 2021/10/18 11:11
 */
public class Hot207 {

    static List<List<Integer>> edges;
    static int[] state;
    static boolean valid = true;

    public static void main(String[] args) {

        int num = 3;
        int[][] pre = {{1, 0}};
        System.out.println(canFinish(num, pre));
    }

    /**
     * 法一、广度优先
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }


    /**
     * 法二、深度优先
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>(numCourses);
        state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private static void dfs(int u) {
        state[u] = 1;
        for (int v : edges.get(u)) {
            if (state[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (state[v] == 1) {
                valid = false;
                return;
            }
        }
        state[u] = 2;
    }

}
