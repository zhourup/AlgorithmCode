package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/17 19:55
 */
public class Hot160 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        node3.next = node5;
        node4.next = node5;
        node5.next = node6;


        ListNode res = getIntersectionNode(node1, node4);
        System.out.println(res.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null) {
            node1 = node1.next;
            len1++;
        }
        while (node2 != null) {
            node2 = node2.next;
            len2++;
        }

        int count = Math.abs(len1 - len2);
        ListNode p1 = headA;
        ListNode p2 = headB;
        if (len1 > len2) {
            while (count > 0) {
                p1 = p1.next;
                count--;
            }
        } else {
            while (count > 0) {
                p2 = p2.next;
                count--;
            }
        }
        while (p1 != null & p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
