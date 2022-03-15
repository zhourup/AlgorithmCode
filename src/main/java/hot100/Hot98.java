package main.java.hot100;

import java.util.LinkedList;
import java.util.List;

public class Hot98 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        head.left = node1;
        head.right = node2;
        System.out.println(isValidBST1(head));
    }

    /**
     * 法一、获取二叉树的中序遍历列表，判断列表是否符合升序
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTravel(root, res);
        if (res.size() == 1) {
            return true;
        }
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void inorderTravel(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTravel(root.left, res);
        res.add(root.val);
        inorderTravel(root.right, res);
    }


    /**
     * 法二、中序遍历时直接判断
     *
     * @param root
     */
    static long pre = Long.MIN_VALUE;

    public static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        //访问左子树
        if (!isValidBST1(root.left)) {
            return false;
        }
        //访问当前节点
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        //访问右子树
        return isValidBST1(root.right);
    }
}
