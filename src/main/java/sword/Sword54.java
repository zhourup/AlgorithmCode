package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 16:33
 */
public class Sword54 {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
    }

    public static void main(String[] args) {

    }


    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorderTraverse(root);
        return res;
    }

    private void inorderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraverse(node.right);
        if (--k == 0) {
            res = node.val;
            return;
        }
        inorderTraverse(node.left);
    }

}
