package main.java.hot100;

public class Hot19 {

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
        int[] nums = {1, 2, 3};
        int n = 2;
        ListNode head = createList(nums);
        //printListNode(head);
        ListNode te = removeNthFromEnd(head, n);
        printListNode(te);
    }

    /**
     * O(N) 一轮遍历
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode point1 = head;
        ListNode point2 = head;
        for (int i = 0; i < n; i++) {
            point1 = point1.next;
        }
        if (point1 == null) {
            head = head.next;
            return head;
        }
        while (point1.next != null) {
            point1 = point1.next;
            point2 = point2.next;
        }
        point2.next = point2.next.next;
        return head;
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

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
