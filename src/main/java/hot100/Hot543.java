package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/16 14:45
 */
public class Hot543 {

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
        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        head.left = node2;
        head.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(diameterOfBinaryTree(head));
    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        max = Math.max(max, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
