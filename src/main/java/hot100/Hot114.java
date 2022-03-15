package main.java.hot100;

import java.util.LinkedList;
import java.util.List;

public class Hot114 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
    }

    /**
     * 法一、先将先序遍历节点收集到集合，再连接
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        List<TreeNode> treeNodes = new LinkedList<>();
        preOrder(root, treeNodes);
        if (treeNodes.size() > 0) {
            TreeNode temp = root;
            temp.left = null;
            for (int i = 1; i < treeNodes.size(); i++) {
                TreeNode node = treeNodes.get(i);
                node.left = null;
                temp.right = node;
                temp = temp.right;
            }
        }
    }

    private static void preOrder(TreeNode root, List<TreeNode> treeNodes) {
        if (root == null) {
            return;
        }
        treeNodes.add(root);
        preOrder(root.left, treeNodes);
        preOrder(root.right, treeNodes);
    }

    /**
     * 法二、原地算法,空间复杂度O(1)将二叉树转为链表
     *
     * @param root
     */
    public static void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
