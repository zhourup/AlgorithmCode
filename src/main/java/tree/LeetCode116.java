package main.java.tree;

/**
 * @author zhourup
 * @date 2021/12/10 13:14
 */
public class LeetCode116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 一个节点做不到，我们就给他安排两个节点，将每一层二叉树节点连接起来  细化到  将每个相邻节点都连接起来
     *
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private static void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        //连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        //连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

}
