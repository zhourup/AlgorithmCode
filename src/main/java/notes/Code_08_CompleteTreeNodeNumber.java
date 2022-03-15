package main.java.notes;

public class Code_08_CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 已知一棵完全二叉树，求其节点的个数（要求：时间复杂度低于O(N)，N为这棵树的节点个数）
     *
     * @param head
     * @return
     */
    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            return (1 << (h - level) + bs(node.right, level + 1, h));
        } else {
            return (1 << (h - level - 1) + bs(node.left, level + 1, h));
        }
    }

    /**
     * 返回一颗完全二叉树的深度
     *
     * @param node
     * @param level
     * @return
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
