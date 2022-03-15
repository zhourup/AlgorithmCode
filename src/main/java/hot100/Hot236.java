package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/19 19:59
 */
public class Hot236 {

    private static TreeNode ans;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        head.left = node1;
        head.right = node2;
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        node4.left = node7;
        node4.right = node8;
        TreeNode res = lowestCommonAncestor(head, node5, node6);
        System.out.println(res.val);

    }

    /**
     * 法一、递归，容易理解，但是时间复杂度高
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }

    private static boolean find(TreeNode root, TreeNode c) {
        if (root == null) {
            return false;
        }
        if (root.val == c.val) {
            return true;
        }
        return (find(root.left, c) || find(root.right, c));
    }

    /**
     * 法二、递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            } else if (lNode == null) {
                return rNode;
            } else {
                return lNode;
            }
        }
        return null;
    }
}
