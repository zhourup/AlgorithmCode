package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/15 22:51
 */
public class LeetCode450 {

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

    }

    /**
     * 思路：先找到目标节点，删除该节点有三种情况
     * 1：目标节点刚好是末端节点，两个子节点都为空，那么它可以直接被删除
     * 2：只有一个非空子节点，那么让它孩子节点接替它的位置
     * 3：如果目标节点有两个子节点，为了不破坏BST的性质，必须找目标节点左子树中最大那个节点或者右子树中最小的那个节点来接替自己
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //这两个if把情况1和2都正确处理了
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //获得右子树最小的节点
            TreeNode minNode = getMinNode(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 获取该树最小的节点
     *
     * @param node
     * @return
     */
    private static TreeNode getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
