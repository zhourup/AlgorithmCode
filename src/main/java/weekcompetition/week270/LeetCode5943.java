package main.java.weekcompetition.week270;

/**
 * @author zhourup
 * @date 2021/12/5 10:57
 */
public class LeetCode5943 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode head = createListSZ(nums);
        ListNode node = deleteMiddle(head);
        printListNode(node);
    }

    public static ListNode deleteMiddle1(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        int index = len / 2;
        ListNode p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        if (p.next == null) {
            return null;
        }
        if (p.next.next == null) {
            p.next = null;
            return head;
        }
        p.next = p.next.next;
        return head;
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (p1 != null) {
            if (p1.next == null) {
                p2.next = p2.next.next;
                return head;
            }
            p1 = p1.next;
            if (p1.next == null) {
                p2.next = p2.next.next;
                return head;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return head;
    }


    private static ListNode createListSZ(int[] nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
