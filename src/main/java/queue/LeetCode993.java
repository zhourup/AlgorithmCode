package main.java.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode993 {
    static Map<Integer, Integer> depth;
    static Map<Integer, TreeNode> parent;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 法一、深度优先，求出每一个节点的深度和父节点
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public static void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    /**
     * 广度优先，使用队列层序遍历
     * 定义四个节点，分别是x节点和y节点，xFather用于记录找到x节点时记录其父节点，yFather用于记录找到y节点时记录其父节点
     * 当遍历完每一层时：
     * 1、若x节点和y节点都没找到，则不做任何事
     * 2、若找到了x节点和y节点，则判断其父节点是否同一个
     * 3、若找到两个节点中的一个，说明两个节点不在同一层，返回false
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins1(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode xNode = null;
        TreeNode yNode = null;
        TreeNode xFather = null;
        TreeNode yFather = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    //找节点
                    if (temp.left.val == x) {
                        xNode = temp.left;
                        xFather = temp;
                    }
                    if (temp.left.val == y) {
                        yNode = temp.left;
                        yFather = temp;
                    }
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    //找节点
                    if (temp.right.val == x) {
                        xNode = temp.right;
                        xFather = temp;
                    }
                    if (temp.right.val == y) {
                        yNode = temp.right;
                        yFather = temp;
                    }
                }
                if (xNode == null && yNode == null) {

                } else if (xNode != null && yNode != null) {
                    return xFather != yFather;
                } else if (size == 0) {
                    return false;
                }
            }
        }
        return false;
    }
}
