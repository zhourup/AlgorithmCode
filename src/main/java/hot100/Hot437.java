package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/29 21:53
 */
public class Hot437 {

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
//        TreeNode head = new TreeNode(10);
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(-3);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(11);
//        TreeNode node6 = new TreeNode(3);
//        TreeNode node7 = new TreeNode(-2);
//        TreeNode node8 = new TreeNode(1);
//        head.left = node1;
//        head.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node4.right = node8;
//        int targetSum = 8;
        TreeNode head = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        head.left = node1;
        head.right = node2;
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        int targetSum = 22;
        System.out.println(pathSum(head, targetSum));
    }


    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    /**
     * rootSum(p,val)表示以节点p为起点向下且满足路径总和为val的路径数目
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
