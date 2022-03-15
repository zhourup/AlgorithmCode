package main.java.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2022/3/8 14:48
 */
public class Sword7 {

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
        int[] nums1 = {3, 9, 20, 15, 7};
        int[] nums2 = {9, 3, 15, 20, 7};
        System.out.println(buildTree(nums1, nums2));
    }

    static Map<Integer, Integer> numToIndex;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        numToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numToIndex.put(inorder[i], i);
        }
        return buildNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildNode(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        if (l1 == r1) {
            return new TreeNode(preorder[l1]);
        }
        TreeNode head = new TreeNode(preorder[l1]);
        int center = numToIndex.get(preorder[l1]);
        head.left = buildNode(preorder, l1 + 1, l1 + center - l2, inorder, l2, center - 1);
        head.right = buildNode(preorder, l1 + center - l2 + 1, r1, inorder, center + 1, r2);
        return head;
    }

}
