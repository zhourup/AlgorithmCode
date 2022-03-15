package main.java.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhourup
 * @date 2021/12/3 19:27
 */
public class LeetCode111 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode head = createTree(nums);
        System.out.println(minDepth(head));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int min = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return min;
                } else if (curr.left == null) {
                    queue.offer(curr.right);
                } else if (curr.right == null) {
                    queue.offer(curr.left);
                } else {
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
            min += 1;
        }
        return min;
    }

    private static TreeNode createTree(int[] arr) {
        TreeNode head = new TreeNode(arr[0]);
        TreeNode[] trees = new TreeNode[arr.length];
        trees[0] = head;
        for (int i = 1; i < arr.length; i++) {
            int parentId = i % 2 == 1 ? (i - 1) / 2 : (i - 2) / 2;
            if (arr[i] == -1) {
                if (i % 2 == 1) {
                    trees[parentId].left = null;
                } else {
                    trees[parentId].right = null;
                }
            } else {
                TreeNode node = new TreeNode(arr[i]);
                trees[i] = node;
                //当前节点是左节点
                if (i % 2 == 1) {
                    trees[parentId].left = node;
                } else {
                    trees[parentId].right = node;
                }
            }

        }
        return head;
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }
}
