package main.java.hot100;

public class Hot148 {

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
        int num = 4;
        int res = num << 1;
        System.out.println(res);
    }

    /**
     * 自底向上归并排序
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;
            while (curr != null) {
                //拆分长度为subLen的链表1
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }


    /**
     * 合并两个有序链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead, tmp1 = head1, tmp2 = head2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if (tmp1 != null) {
            tmp.next = tmp1;
        } else {
            tmp.next = tmp2;
        }
        return dummyHead.next;
    }
}
