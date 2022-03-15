package main.java.hot100;

public class Hot2 {

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
        int[] nums1 = {9, 9, 9, 9, 9, 9, 9, 9};
        int[] nums2 = {9, 9, 9, 9};
        ListNode head1 = createList(nums1);
        ListNode head2 = createList(nums2);
        ListNode res = addTwoNumbers(head1, head2);
        printListNode(res);
    }

    /**
     * 自己写的
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur);
            temp.next = node;
            temp = temp.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            p = p.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode createList(int[] nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }
}
