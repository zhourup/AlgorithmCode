package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/11 14:25
 */
public class LeetCode106 {

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
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode head = buildTree(inorder, postorder);
        printTree(head);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode head = buildMyTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return head;
    }

    private static TreeNode buildMyTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        int headIndex = findNumIndex(inorder, postorder[r2], l1, r1);
        int leftL = headIndex - l1;
        TreeNode head = new TreeNode(postorder[r2]);
        head.left = buildMyTree(inorder, l1, headIndex - 1, postorder, l2, l2 + leftL - 1);
        head.right = buildMyTree(inorder, headIndex + 1, r1, postorder, l2 + leftL, r2 - 1);
        return head;
    }

    private static int findNumIndex(int[] nums, int num, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                return i;
            }
        }
        return 0;
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
