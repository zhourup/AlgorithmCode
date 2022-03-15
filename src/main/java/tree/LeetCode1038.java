package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/15 11:33
 */
public class LeetCode1038 {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        head.left = node1;
        head.right = node2;
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);
        node4.right = node7;
        node6.right = node8;
        TreeNode res = bstToGst(head);
        printTree(res);
    }

    static int curr = 0;

    public static TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        curr = curr + root.val;
        root.val = curr;
        traverse(root.left);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }
}
