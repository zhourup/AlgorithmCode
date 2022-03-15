package main.java.hot100;

import java.util.LinkedList;
import java.util.List;

public class Hot94 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        head.right = node1;
        node1.left = node2;
        inorderTraversal(head);
    }

    /**
     * 递归+中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTravel(res, root);
        return res;
    }

    private static void inorderTravel(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravel(res, root.left);
        res.add(root.val);
        inorderTravel(res, root.right);
    }

}
