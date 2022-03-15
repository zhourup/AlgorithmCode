package main.java.weekcompetition.week270;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/12/5 11:25
 */
public class LeetCode5944 {

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
        int[] nums = new int[]{5, 1, 2, 3, -1, 6, 4};
        TreeNode head = createTree(nums);
        System.out.println(getDirections(head, 3, 6));

    }

    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node1 = findNode(root, startValue);
        TreeNode node2 = findNode(root, destValue);
        TreeNode head = lowestCommonAncestor(root, node1, node2);
        StringBuffer path1 = new StringBuffer();
        StringBuffer path2 = new StringBuffer();
        TreeNode node = node1;
        while (node != head) {
            path1.append('U');
            node = parentMap.get(node);
        }
        node = node2;
        while (node != head) {
            TreeNode parent = parentMap.get(node);
            if (node == parent.left) {
                path2.append('L');
            } else {
                path2.append('R');
            }
            node = parent;
        }
        path2.reverse();
        StringBuffer directions = new StringBuffer();
        directions.append(path1);
        directions.append(path2);
        return directions.toString();
    }

    /**
     * 查找二叉树中值为val的节点，并将查找过程中的(节点,其父节点)存到map
     */
    public static TreeNode findNode(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        TreeNode node1 = findNode(node.left, val);
        if (node1 != null) {
            parentMap.put(node.left, node);
            return node1;
        }
        TreeNode node2 = findNode(node.right, val);
        if (node2 != null) {
            parentMap.put(node.right, node);
            return node2;
        }
        return null;
    }

    /**
     * 查找p和q两个节点的最近父节点
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            } else if (lNode == null) {
                return rNode;
            } else {
                return lNode;
            }
        }
        return null;
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
