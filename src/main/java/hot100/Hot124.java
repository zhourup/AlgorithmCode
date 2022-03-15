package main.java.hot100;

public class Hot124 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(-2);
        root.left = node1;
        root.right = node2;
        System.out.println(maxPathSum(root));
    }

    static int maxSum = Integer.MIN_VALUE;

    private static int pathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftVal = Math.max(pathSum(node.left), 0);
        int rightVal = Math.max(pathSum(node.right), 0);
        int curVal = node.val + leftVal + rightVal;
        maxSum = Math.max(maxSum, curVal);
        return Math.max(leftVal, rightVal) + node.val;
    }

    public static int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }
}
