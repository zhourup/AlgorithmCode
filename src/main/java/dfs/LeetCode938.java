package main.java.dfs;

public class LeetCode938 {

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
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node18 = new TreeNode(18);
        node10.left = node5;
        node10.right = node15;
        node5.left = node3;
        node5.right = node7;
        node15.right = node18;
        System.out.println(rangeSumBST(node10, 7, 15));
    }

    static int res;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        res = 0;
        dfs(root, low, high);
        return res;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param low
     * @param high
     */
    private static void inOrderVisit(TreeNode node, int low, int high) {
        if (node.left != null) {
            inOrderVisit(node.left, low, high);
        }
        if (node.val >= low && node.val <= high) {
            res += node.val;
        }
        System.out.println(node.val);
        if (node.right != null) {
            inOrderVisit(node.right, low, high);
        }
    }

    /**
     * dfs
     *
     * @param node
     * @param low
     * @param right
     */
    private static void dfs(TreeNode node, int low, int right) {
        if (node != null) {
            if (low <= node.val && node.val <= right) {
                res += node.val;
            }
            if (node.val > low) {
                dfs(node.left, low, right);
            }
            if (node.val < right) {
                dfs(node.right, low, right);
            }
        }
    }
}
