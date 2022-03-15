package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/10 15:13
 */
public class LeetCode114 {

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
        int[] nums = new int[]{1, 2, 5, 3, 4, -1, 6};
        TreeNode head = createTree(nums);
        flatten(head);
        printTree(head);
    }

    /**
     * 先将左节点压平，右节点压平，将左节点放到root的右节点上，然后获取到其最后一个节点，将右节点连接到其之后
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }
        tail.right = right;
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
