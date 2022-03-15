package main.java.linklist;

public class LeetCode21 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode head1 = generateList(nums1);
        ListNode head2 = generateList(nums2);
        printList(mergeTwoLists1(head1, head2));
    }

    private static ListNode generateList(int[] nums) {
        if (nums.length <= 1) {
            return new ListNode(nums[0]);
        }
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = temp.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 方法一：自己，迭代
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null && l2 != null) {
            temp.next = l2;
        } else if (l2 == null && l1 != null) {
            temp.next = l1;
        }
        return head.next;
    }

    /**
     * 方法二、递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if (l1.val<l2.val){
            l1.next=mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }
}
