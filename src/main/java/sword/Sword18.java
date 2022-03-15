package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/13 17:00
 */
public class Sword18 {

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


    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
