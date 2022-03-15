package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/11 21:11
 */
public class LeetCode230 {

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
        int[] nums = new int[]{5,3,6,2,4,-1,-1,1};
        TreeNode head = createTree(nums);
        int k = 3;
        System.out.println(kthSmallest(head, k));
    }

    static int res = 0;
    static int curr = 0;

    public static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        curr++;
        if (curr == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
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

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }
}
