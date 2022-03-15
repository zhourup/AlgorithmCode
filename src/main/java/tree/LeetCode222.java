package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/26 21:14
 */
public class LeetCode222 {

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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        TreeNode head = createTree(nums);
        System.out.println(countNodes(head));
    }

    /**
     * 先判断是否为满二叉树，若为满二叉树，则可按照2的h次方-1来计算节点个数，若不是满二叉树，则按照普通二叉树来计算
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        //左右子树高度相同，为满二叉树
        if (hl == hr) {
            return (int) (Math.pow(2, hl) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 普通二叉树计算节点个数方法
     *
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
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
}
