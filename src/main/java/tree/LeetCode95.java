package main.java.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/16 11:11
 */
public class LeetCode95 {

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
        List<TreeNode> list = generateTrees(3);
    }

    /**
     * 思路：
     * 1、穷举root节点的所有可能
     * 2、递归构造出左右子树的合法BST
     * 3、给root节点穷举所有左右子树的组合
     *
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    /**
     * 构造[left,right]区间组成的BST
     *
     * @param left
     * @param right
     * @return
     */
    private static List<TreeNode> build(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        // 穷举root节点的所有可能性
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = build(left, i - 1);
            List<TreeNode> rightTree = build(i + 1, right);
            //给root节点穷举所有可能左右子树的组合
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
