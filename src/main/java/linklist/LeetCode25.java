package main.java.linklist;

/**
 * @author zhourup
 * @date 2021/12/9 21:13
 */
public class LeetCode25 {

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
        int[] nums = new int[]{1, 2};
        int k = 2;
        ListNode head = createListNode(nums);
        printListNode(head);
        ListNode after = reverseKGroup(head, k);
        printListNode(after);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return a;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 返回[a,b)之间的反转后的节点
     *
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, curr = a, next = a;
        while (curr != b) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    private static ListNode createListNode(int[] nums) {
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
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
