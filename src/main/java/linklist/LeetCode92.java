package main.java.linklist;

/**
 * @author zhourup
 * @date 2021/12/9 16:45
 */
public class LeetCode92 {

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
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = createListNode(nums);
        printListNode(head);
        ListNode reverse = reverseBetween(head, 1, 4);
        System.out.println("反转后");
        printListNode(reverse);
    }

    /**
     * 法二、递归反转链表的一部分,反转链表[m,n]区间的元素
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        //前进到反转的起点触发base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    static ListNode tail = null;

    private static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tail = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

    /**
     * 法一，容易想，但细节比较多
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        dummy.next = head;
        for (int i = 0; i < left - 1; i++) {
            dummy = dummy.next;
        }
        ListNode p = dummy.next;
        ListNode tail = null;
        ListNode reverse = new ListNode(-1);
        int count = right - left + 1;
        while (count > 0) {
            //使用头插法将反转区间的节点头插到reverse里，需要记录第一个，到时他就是尾
            ListNode p1 = p.next;
            p.next = null;
            ListNode temp = reverse.next;
            reverse.next = p;
            p.next = temp;
            if (count == right - left + 1) {
                tail = p;
            }
            p = p1;
            count--;
        }
        dummy.next = reverse.next;
        tail.next = p;
        return res.next;
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
            System.out.println(head.val);
            head = head.next;
        }
    }
}
