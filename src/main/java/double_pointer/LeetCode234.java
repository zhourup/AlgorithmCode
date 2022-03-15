package main.java.double_pointer;

public class LeetCode234 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        ListNode head = new ListNode(a[0]);
        ListNode root = head;
        for (int i = 1; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            root.next = temp;
            root = root.next;
        }
        root.next = null;
        printListNode(head);

        System.out.println(isPalindrome(head));

    }

    /**
     * 输出链表的内容
     *
     * @param head head
     */
    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 双指针法，将链表后半段倒置，再判断
     *
     * @param head head
     * @return result
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverse(slow.next);
        while (head != null && head2 != null) {
            if (head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    /**
     * 将给定的链表倒置
     *
     * @param head head
     * @return ListNode
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

}
