package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/10 21:02
 */
public class LeetCode654 {
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
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode head = constructMaximumBinaryTree(nums);
    }

    /**
     * 法一
     *
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode head = constructTree(nums, 0, nums.length - 1);
        return head;
    }

    private static TreeNode constructTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = getMaxNumIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructTree(nums, left, index - 1);
        root.right = constructTree(nums, index + 1, right);
        return root;
    }

    private static int getMaxNumIndex(int[] nums, int left, int right) {
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
