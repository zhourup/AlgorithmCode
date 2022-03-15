package main.java.double_pointer;

/**
 * @author zhourup
 * @date 2021/12/3 23:20
 */
public class LeetCode876 {

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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = createListSZ(nums);
        ListNode node = middleNode(head);
        System.out.println(node.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null) {
            if (p1.next == null) {
                return p2;
            }
            p1 = p1.next;
            if (p1.next == null) {
                return p2.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.next;
    }

}
