package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

public class Hot105 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode head = buildTree(pre, in);
        printTree(head);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, len - 1, map, 0, len - 1);
    }

    private static TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = myBuildTree(preorder, preLeft + 1, preLeft + pIndex - inLeft, map, inLeft, pIndex - 1);
        root.right = myBuildTree(preorder, preLeft + pIndex - inLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

}
