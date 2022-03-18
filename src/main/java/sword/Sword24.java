package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/19 0:04
 */
public class Sword24 {

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

    }

    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode next = head;
        while (next != null) {
            ListNode tmp = next;
            next = next.next;
            tmp.next = null;
            tmp.next = dummyHead.next;
            dummyHead.next = tmp;
        }
        return dummyHead.next;
    }
}
