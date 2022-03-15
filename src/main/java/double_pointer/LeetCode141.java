package main.java.double_pointer;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {
    public static void main(String[] args) {
        int[] nums={3,2,0,4};

    }

    /**
     * 方法一：哈希表，通过检查一个结点是否被访问过来判断链表是否为环形链表
     *
     * @param head head
     * @return result
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<ListNode>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二，双指针
     *
     * @param head head
     * @return result
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
