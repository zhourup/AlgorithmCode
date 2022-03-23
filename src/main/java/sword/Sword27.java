package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/23 23:46
 */
public class Sword27 {

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


    /**
     * 输入一棵二叉树，返回它的镜像
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = tmp;
        return root;
    }
}
