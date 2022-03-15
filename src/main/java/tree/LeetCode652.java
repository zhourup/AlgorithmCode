package main.java.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/12/11 14:53
 */
public class LeetCode652 {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        head.right = node;
        findDuplicateSubtrees(head);
    }

    /**
     * 记录室友子树以及出现的次数
     */
    static Map<String, Integer> map = new HashMap<>();

    /**
     * 记录重复的子树根节点
     */
    static List<TreeNode> res = new LinkedList<>();

    /**
     * 思路：需要知道两点：
     * 1、以我为根的这棵二叉树长啥样：将每个节点的后序遍历序列化成字符串
     * 2、以其他节点为根的树都长啥样：将每个结点序列化成字符串存入map，以及该字符串出现的次数
     *
     * @param root
     * @return
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * 返回该节点后序遍历序列化后的字符串
     *
     * @param root
     * @return
     */
    private static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        if (map.containsKey(subTree) && map.get(subTree) == 1) {
            res.add(root);
        }
        map.put(subTree, map.getOrDefault(subTree, 0) + 1);
        return subTree;
    }
}
