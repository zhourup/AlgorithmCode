//package temp.autumn.ant;
//
//import sun.dc.pr.PRError;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main2 {
//
//    static class Node {
//        int id;
//        int val;
//        List<Node> subNodes;
//
//        public Node(int id) {
//            this.id = id;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] nums = new int[n - 1][2];
//        for (int i = 0; i < n - 1; i++) {
//            nums[i][0] = in.nextInt();
//            nums[i][1] = in.nextInt();
//        }
//        System.out.println(minOperateTime(nums, n));
//    }
//
//    private static List<List<Integer>> buildGraph(int[][] nums, int n) {
//        List<List<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            List<Integer> temp = new ArrayList<>();
//            graph.add(temp);
//        }
//        for (int[] num : nums) {
//            List<Integer> curr = graph.get(num[0]);
//            curr.add(num[1]);
//        }
//        return graph;
//    }
//
//    private static Node buildTree(List<List<Integer>> graph) {
//        for (int i = 1; i < graph.size(); i++) {
//            Node node = new Node(i);
//            node.val = 1;
//
//        }
//    }
//
//    private static int minOperateTime(int[][] nums, int n) {
//        List<List<Integer>> lists = buildGraph(nums, n);
//        Node node = buildTree(lists);
//        return 3;
//    }
//
//}
